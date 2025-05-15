package br.com.sulimann.clean_arch.application.usuario.create;

import br.com.sulimann.clean_arch.domain.usuario.Usuario;
import br.com.sulimann.clean_arch.domain.usuario.UsuarioGateway;

public class CriarUsuarioUseCase {

  private final UsuarioGateway usuarioGateway;

  public CriarUsuarioUseCase(UsuarioGateway usuarioGateway) {
    this.usuarioGateway = usuarioGateway;
  }

  public CriarUsuarioOutput execute(CriarUsuarioInput input) {
    var usuario = Usuario.newUsuario(null, input.nome(), input.email(), input.telefone(), input.ddd(), input.rua(), input.numero(), input.bairro(), input.cidade(), input.estado(), input.cep());
    return CriarUsuarioOutput.of(usuarioGateway.create(usuario));
  }



}
