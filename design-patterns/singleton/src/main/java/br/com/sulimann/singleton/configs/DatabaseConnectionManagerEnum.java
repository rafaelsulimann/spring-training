package br.com.sulimann.singleton.configs;

public enum DatabaseConnectionManagerEnum {
  INSTANCE;

  private boolean connect = false;

  public void connect(){
    if(!connect){
      connect = true;
      System.out.println("Connected to the database");
    } else {
      System.out.println("Already connected to the database");
    }
  }

  public void disconnect(){
    if(connect){
      connect = false;
      System.out.println("Disconnected from the database");
    } else {
      System.out.println("Already disconnected from the database");
    }
  }

  public boolean isConnected(){
    return connect;
  }

}
