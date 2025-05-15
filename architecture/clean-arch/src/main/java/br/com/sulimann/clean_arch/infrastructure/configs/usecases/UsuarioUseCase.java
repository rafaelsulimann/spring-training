package br.com.sulimann.clean_arch.infrastructure.configs.usecases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sulimann.clean_arch.application.usuario.create.CriarUsuarioUseCase;
import br.com.sulimann.clean_arch.domain.usuario.UsuarioGateway;

@Configuration
public class UsuarioUseCase {

  private final UsuarioGateway usuarioGateway;

  public UsuarioUseCase(UsuarioGateway usuarioGateway) {
    this.usuarioGateway = usuarioGateway;
  }

  @Bean
  CriarUsuarioUseCase criarUsuarioUseCase() {
    return new CriarUsuarioUseCase(usuarioGateway);
  }



}
