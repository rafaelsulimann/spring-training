package br.com.sulimann.factory;

public class NotificacaoEmail implements Notificacao {

  @Override
  public void enviar(String message) {
    System.out.println("Enviando notificação por email: " + message);
  }

}
