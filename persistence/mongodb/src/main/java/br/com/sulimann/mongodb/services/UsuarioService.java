package br.com.sulimann.mongodb.services;

import org.springframework.stereotype.Service;

import br.com.sulimann.mongodb.dtos.CreateUserRequest;
import br.com.sulimann.mongodb.dtos.CreateUserResponse;
import br.com.sulimann.mongodb.entities.Usuario;
import br.com.sulimann.mongodb.repositories.UsuarioRepository;

@Service
public class UsuarioService {

  private final UsuarioRepository usuarioRepository;

  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public CreateUserResponse create(CreateUserRequest usuario) {
    var entity = new Usuario(null, usuario.nome(), usuario.email(), usuario.telefones(), usuario.salario());
    var saved = usuarioRepository.save(entity);
    return new CreateUserResponse(saved.getId().toString(), saved.getNome(), saved.getEmail(), saved.getTelefones(), saved.getSalario());
  }

}
