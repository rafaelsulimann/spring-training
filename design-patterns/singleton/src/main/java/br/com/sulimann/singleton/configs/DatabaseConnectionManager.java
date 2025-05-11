package br.com.sulimann.singleton.configs;

public class DatabaseConnectionManager {

  private static volatile DatabaseConnectionManager instance;
  private boolean connect = false;

  private DatabaseConnectionManager() {
  }

  public static DatabaseConnectionManager getInstance() {
    if (instance == null) {
      synchronized (DatabaseConnectionManager.class) {
        if (instance == null) {
          instance = new DatabaseConnectionManager();
        }
      }
    }
    return instance;
  }

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
