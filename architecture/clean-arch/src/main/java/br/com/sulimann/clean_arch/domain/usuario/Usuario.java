package br.com.sulimann.clean_arch.domain.usuario;

public class Usuario {

  private String id;
  private String nome;
  private String email;
  private Telefone telefone;
  private Endereco endereco;

  private Usuario(String id, String nome, String email, Telefone telefone, Endereco endereco) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.endereco = endereco;
  }

  public static Usuario newUsuario(String id, String nome, String email, String telefone, String ddd, String rua, String numero, String bairro, String cidade, String estado, String cep) {
    return new Usuario(id, nome, email, Telefone.newTelefone(telefone, ddd), Endereco.newEndereco(rua, numero, bairro, cidade, estado, cep));
  }

  public String getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public Telefone getTelefone() {
    return telefone;
  }

  public Endereco getEndereco() {
    return endereco;
  }

}
