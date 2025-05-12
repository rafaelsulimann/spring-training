package br.com.sulimann.adapter.payment;

import org.springframework.stereotype.Component;

import br.com.sulimann.adapter.external.ThirdPartyPaymentService;

@Component
public class ThirdPartyPaymentAdapter implements PaymentProcessor {

    private final ThirdPartyPaymentService thirdPartyService;

    // Injeção de dependência via construtor
    public ThirdPartyPaymentAdapter(ThirdPartyPaymentService thirdPartyService) {
        this.thirdPartyService = thirdPartyService;
    }

    @Override
    public boolean processPayment(double amount, String currency, String accountId) {
        try {
            String transactionId = thirdPartyService.makePayment(accountId, amount, currency);
            return transactionId != null && !transactionId.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PaymentStatus checkStatus(String transactionId) {
        int statusCode = thirdPartyService.getPaymentStatus(transactionId);

        // Convertendo os códigos de status do serviço externo para nossa enumeração
        return switch (statusCode) {
            case 0 -> PaymentStatus.FAILED;
            case 1 -> PaymentStatus.PENDING;
            case 2 -> PaymentStatus.COMPLETED;
            case 3 -> PaymentStatus.REFUNDED;
            default -> PaymentStatus.FAILED;
        };
    }
}
