package br.com.sulimann.singleton.configs;

public enum DatabaseConnectionManagerEnum {
  INSTANCE;

  private boolean connect = false;
  private String connectionUrl;
  private String username;
  private String password;

  // Construtor do ENUM
  DatabaseConnectionManagerEnum() {
    // Aqui você pode adicionar sua lógica de inicialização
    // Mas ele sempre inicializa com os valores padrões quando a aplicação é iniciada
    this.connectionUrl = "jdbc:mysql://localhost:3306/mydatabase";
    this.username = "root";
    this.password = "password";
    System.out.println("Inicializando conexão com o banco de dados...");
  }

  public void connect(){
    if(!connect){
      connect = true;
      System.out.println("Connected to the database: " + connectionUrl);
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
