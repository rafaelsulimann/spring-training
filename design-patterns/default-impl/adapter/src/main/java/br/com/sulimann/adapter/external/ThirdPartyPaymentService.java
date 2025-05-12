package br.com.sulimann.adapter.external;

public class ThirdPartyPaymentService {
  public String makePayment(String account, double value, String currencyCode) {
    // Lógica de integração com o serviço externo
    System.out.println("Processando pagamento via serviço externo...");
    return "TRX" + System.currentTimeMillis(); // Retorna ID da transação
  }

  public int getPaymentStatus(String referenceCode) {
    // 0: falha, 1: pendente, 2: completo, 3: estornado
    System.out.println("Verificando status do pagamento " + referenceCode);
    return 2; // Simulando um pagamento completo
  }
}
