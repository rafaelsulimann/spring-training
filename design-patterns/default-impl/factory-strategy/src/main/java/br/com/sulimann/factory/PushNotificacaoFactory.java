package br.com.sulimann.factory;

import org.springframework.stereotype.Component;

@Component("push")
public class PushNotificacaoFactory extends NotificacaoFactory {

  @Override
  public Notificacao criarNotificacao() {
    return new NotificacaoPush();
  }

}
