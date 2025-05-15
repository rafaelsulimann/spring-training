package br.com.sulimann.clean_arch.domain.usuario;

public class Telefone {

  private String numero;
  private String ddd;

  private Telefone(String numero, String ddd) {
    this.numero = numero;
    this.ddd = ddd;
  }

  public static Telefone newTelefone(String numero, String ddd) {
    return new Telefone(numero, ddd);
  }

  public String getNumero() {
    return numero;
  }

  public String getDdd() {
    return ddd;
  }
}
