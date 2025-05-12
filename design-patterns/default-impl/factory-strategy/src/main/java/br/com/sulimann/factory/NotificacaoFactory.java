package br.com.sulimann.factory;

public abstract class NotificacaoFactory {

  public void enviarNotificacao(String message) {
    Notificacao notificacao = criarNotificacao();
    notificacao.enviar(message);
  }

  public abstract Notificacao criarNotificacao();

}
