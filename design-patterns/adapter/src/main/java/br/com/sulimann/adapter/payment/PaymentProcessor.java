package br.com.sulimann.adapter.payment;

public interface PaymentProcessor {
  boolean processPayment(double amount, String currency, String accountId);
  PaymentStatus checkStatus(String transactionId);
}
