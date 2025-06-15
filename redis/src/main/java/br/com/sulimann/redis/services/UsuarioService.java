package br.com.sulimann.redis.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.sulimann.redis.dtos.CriarUsuarioRequest;
import br.com.sulimann.redis.dtos.UsuarioResponse;
import br.com.sulimann.redis.entities.Usuario;
import br.com.sulimann.redis.repositories.UsuarioRepository;

@Service
public class UsuarioService {

  private final UsuarioRepository usuarioRepository;

  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public UsuarioResponse create(CriarUsuarioRequest request){
    Usuario usuario = new Usuario(null, request.nome(), request.email());
    usuario = usuarioRepository.save(usuario);
    return new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail());
  }

  @Cacheable(value = "usuarios", key = "#pageable.pageNumber")
  public Page<UsuarioResponse> findAll(Pageable pageable){
    Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
    return usuarios.map(UsuarioResponse::new);
  }

  @Cacheable(value = "usuarios", condition = "#email.contains('gmail')")
  public UsuarioResponse findByEmail(String email) {
    var usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    return new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail());
  }

}
