package br.com.sulimann.redis.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.redis.dtos.CriarUsuarioRequest;
import br.com.sulimann.redis.dtos.UsuarioResponse;
import br.com.sulimann.redis.services.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @PostMapping
  public ResponseEntity<UsuarioResponse> create(@RequestBody @Valid CriarUsuarioRequest request){
    return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.create(request));
  }

  @GetMapping
  public ResponseEntity<Page<UsuarioResponse>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
    return ResponseEntity.ok(usuarioService.findAll(pageable));
  }

  @GetMapping(value = "/{email}")
  public ResponseEntity<UsuarioResponse> findByEmail(@PathVariable @NotBlank String email){
    return ResponseEntity.ok(usuarioService.findByEmail(email));
  }

}
