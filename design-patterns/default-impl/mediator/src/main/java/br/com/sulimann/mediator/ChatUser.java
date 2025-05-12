package br.com.sulimann.mediator;

public class ChatUser extends User {

  public ChatUser(ChatMediator mediator, String name) {
    super(mediator, name);
    mediator.addUser(this);
  }

  @Override
  public void receive(String message) {
    System.out.println(this.name + " recebeu: " + message);
  }

}
