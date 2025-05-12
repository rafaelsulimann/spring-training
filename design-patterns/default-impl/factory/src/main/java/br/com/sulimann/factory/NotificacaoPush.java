package br.com.sulimann.factory;

public class NotificacaoPush implements Notificacao {

  @Override
  public void enviar(String message) {
    System.out.println("Enviando notificação por push: " + message);
  }

}
