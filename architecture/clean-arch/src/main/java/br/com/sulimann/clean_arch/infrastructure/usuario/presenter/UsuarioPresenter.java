package br.com.sulimann.clean_arch.infrastructure.usuario.presenter;

import br.com.sulimann.clean_arch.application.usuario.create.CriarUsuarioOutput;
import br.com.sulimann.clean_arch.infrastructure.usuario.dtos.EnderecoResponse;
import br.com.sulimann.clean_arch.infrastructure.usuario.dtos.TelefoneResponse;
import br.com.sulimann.clean_arch.infrastructure.usuario.dtos.UsuarioResponse;

public interface UsuarioPresenter {

  static UsuarioResponse toResponse(CriarUsuarioOutput usuario) {
    return new UsuarioResponse(usuario.id(), usuario.nome(), usuario.email(), new TelefoneResponse(usuario.telefone(), usuario.ddd()), new EnderecoResponse(usuario.rua(), usuario.numero(), usuario.bairro(), usuario.cidade(), usuario.estado(), usuario.cep()));
  }
}
