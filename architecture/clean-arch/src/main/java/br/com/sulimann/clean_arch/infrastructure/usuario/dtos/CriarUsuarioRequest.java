package br.com.sulimann.clean_arch.infrastructure.usuario.dtos;

public record CriarUsuarioRequest(String nome, String email, String telefone, String ddd, String rua, String numero,
    String bairro, String cidade, String estado, String cep) {

}
