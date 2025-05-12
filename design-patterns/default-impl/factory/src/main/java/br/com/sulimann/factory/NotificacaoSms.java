package br.com.sulimann.factory;

public class NotificacaoSms implements Notificacao {

  @Override
  public void enviar(String message) {
    System.out.println("Enviando notificação por SMS: " + message);
  }

}
