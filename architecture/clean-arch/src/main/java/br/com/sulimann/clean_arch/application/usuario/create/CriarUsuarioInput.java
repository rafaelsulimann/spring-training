package br.com.sulimann.clean_arch.application.usuario.create;

public record CriarUsuarioInput(
  String nome,
  String email,
  String telefone,
  String ddd,
  String rua,
  String numero,
  String bairro,
  String cidade,
  String estado,
  String cep
) {

}
