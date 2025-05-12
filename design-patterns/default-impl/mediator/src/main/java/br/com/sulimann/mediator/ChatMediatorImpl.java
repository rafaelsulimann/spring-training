package br.com.sulimann.mediator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ChatMediatorImpl implements ChatMediator {

  private List<User> users = new ArrayList<>();

  @Override
  public void sendMessage(String message, User user) {
    for (User u : this.users) {
      if (u != user) {
        u.receive(message);
      }
    }
  }

  @Override
  public void addUser(User user) {
    this.users.add(user);
  }
}
