package br.com.sulimann.factory;

public class NotificacaoWhatsapp implements Notificacao {

  @Override
  public void enviar(String message) {
    System.out.println("Enviando notificação por WhatsApp: " + message);
  }

}
