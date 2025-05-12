package br.com.sulimann.adapter.service;

import org.springframework.stereotype.Service;

import br.com.sulimann.adapter.payment.PaymentProcessor;

@Service
public class OrderService {

    private final PaymentProcessor paymentProcessor;

    public OrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public boolean placeOrder(String orderId, double amount, String currency, String accountId) {
        // Lógica de criação do pedido

        // Processamento do pagamento usando o adapter
        boolean paymentSuccess = paymentProcessor.processPayment(amount, currency, accountId);

        if (paymentSuccess) {
            // Finaliza o pedido
            System.out.println("Pedido " + orderId + " processado com sucesso!");
        } else {
            System.out.println("Falha no pagamento do pedido " + orderId);
        }

        return paymentSuccess;
    }
}
