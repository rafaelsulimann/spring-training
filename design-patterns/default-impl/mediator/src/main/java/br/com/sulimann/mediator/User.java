package br.com.sulimann.mediator;

public abstract class User {

  protected ChatMediator mediator;
  protected String name;

  public User(ChatMediator mediator, String name) {
    this.mediator = mediator;
    this.name = name;
  }

  public void send(String message){
    System.out.println(this.name + " enviou: " + message);
    mediator.sendMessage(message, this);
  };

  public abstract void receive(String message);
}
