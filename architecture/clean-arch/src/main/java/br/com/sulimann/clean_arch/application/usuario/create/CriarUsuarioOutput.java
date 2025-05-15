package br.com.sulimann.clean_arch.application.usuario.create;

import br.com.sulimann.clean_arch.domain.usuario.Usuario;

public record CriarUsuarioOutput(String id, String nome, String email, String telefone, String ddd, String rua, String numero, String bairro, String cidade, String estado, String cep)  {

  public static CriarUsuarioOutput of(Usuario usuario) {
    return new CriarUsuarioOutput(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone().getNumero(), usuario.getTelefone().getDdd(), usuario.getEndereco().getRua(), usuario.getEndereco().getNumero(), usuario.getEndereco().getBairro(), usuario.getEndereco().getCidade(), usuario.getEndereco().getEstado(), usuario.getEndereco().getCep());
  }

}
