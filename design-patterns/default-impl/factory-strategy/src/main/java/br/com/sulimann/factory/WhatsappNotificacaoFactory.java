package br.com.sulimann.factory;

import org.springframework.stereotype.Component;

@Component("whatsapp")
public class WhatsappNotificacaoFactory extends NotificacaoFactory {

  @Override
  public Notificacao criarNotificacao() {
    return new NotificacaoWhatsapp();
  }

}
