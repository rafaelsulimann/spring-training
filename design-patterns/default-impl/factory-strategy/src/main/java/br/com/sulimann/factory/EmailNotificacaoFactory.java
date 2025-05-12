package br.com.sulimann.factory;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotificacaoFactory extends NotificacaoFactory {

  @Override
  public Notificacao criarNotificacao() {
    return new NotificacaoEmail();
  }

}
