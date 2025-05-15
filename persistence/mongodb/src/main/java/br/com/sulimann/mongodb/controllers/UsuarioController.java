package br.com.sulimann.mongodb.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.mongodb.dtos.CreateUserRequest;
import br.com.sulimann.mongodb.dtos.CreateUserResponse;
import br.com.sulimann.mongodb.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @PostMapping
  public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest usuario) {
    return ResponseEntity.ok().body(usuarioService.create(usuario));
  }

}
