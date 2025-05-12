package br.com.sulimann.factory;

import org.springframework.stereotype.Component;

@Component("sms")
public class SmsNotificacaoFactory extends NotificacaoFactory {

  @Override
  public Notificacao criarNotificacao() {
    return new NotificacaoSms();
  }

}
