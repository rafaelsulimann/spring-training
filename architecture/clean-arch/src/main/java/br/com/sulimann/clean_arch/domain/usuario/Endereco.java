package br.com.sulimann.clean_arch.domain.usuario;

public class Endereco {

  private String rua;
  private String numero;
  private String bairro;
  private String cidade;
  private String estado;
  private String cep;

  private Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
    this.rua = rua;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  public static Endereco newEndereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
    return new Endereco(rua, numero, bairro, cidade, estado, cep);
  }

  public String getRua() {
    return rua;
  }

  public String getNumero() {
    return numero;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public String getEstado() {
    return estado;
  }

  public String getCep() {
    return cep;
  }




}
