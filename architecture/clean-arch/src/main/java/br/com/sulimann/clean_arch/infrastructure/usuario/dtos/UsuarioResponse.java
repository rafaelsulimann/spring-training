package br.com.sulimann.clean_arch.infrastructure.usuario.dtos;

public record UsuarioResponse(String id, String nome, String email, TelefoneResponse telefone, EnderecoResponse endereco) {

}
