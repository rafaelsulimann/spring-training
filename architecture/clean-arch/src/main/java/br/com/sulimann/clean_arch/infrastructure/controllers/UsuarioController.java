package br.com.sulimann.clean_arch.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.clean_arch.application.usuario.create.CriarUsuarioInput;
import br.com.sulimann.clean_arch.application.usuario.create.CriarUsuarioUseCase;
import br.com.sulimann.clean_arch.infrastructure.usuario.dtos.CriarUsuarioRequest;
import br.com.sulimann.clean_arch.infrastructure.usuario.dtos.UsuarioResponse;
import br.com.sulimann.clean_arch.infrastructure.usuario.presenter.UsuarioPresenter;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

  private final CriarUsuarioUseCase criarUsuarioUseCase;

  public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase) {
    this.criarUsuarioUseCase = criarUsuarioUseCase;
  }

  @PostMapping
  public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody CriarUsuarioRequest usuarioRequest) {
    var input = new CriarUsuarioInput(usuarioRequest.nome(), usuarioRequest.email(), usuarioRequest.telefone(), usuarioRequest.ddd(), usuarioRequest.rua(), usuarioRequest.numero(), usuarioRequest.bairro(), usuarioRequest.cidade(), usuarioRequest.estado(), usuarioRequest.cep());
    return ResponseEntity.ok(UsuarioPresenter.toResponse(criarUsuarioUseCase.execute(input)));
  }


}
