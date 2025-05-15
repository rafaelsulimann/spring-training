package br.com.sulimann.postgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.postgres.entities.Usuario;
import br.com.sulimann.postgres.repositories.UsuarioRepository;
import br.com.sulimann.postgres.specifications.UsuarioSpec;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @GetMapping
  public ResponseEntity<Page<Usuario>> findAll(
    @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
    UsuarioSpec spec
  ) {
    return ResponseEntity.ok(usuarioRepository.findAll(spec, pageable));
  }
}
