package br.com.sulimann.prototype;

import java.util.UUID;

import lombok.Getter;

@Getter
public class User implements Prototype<User> {

  private UUID id;
  private String name;
  private String email;
  private String password;

  public User(String name, String email, String password) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.email = email;
    this.password = password;
  }

  private User(User user) {
    this.id = user.id;
    this.name = user.name;
    this.email = user.email;
    this.password = user.password;
  }

  public User clone() {
    return new User(this);
  }



}
