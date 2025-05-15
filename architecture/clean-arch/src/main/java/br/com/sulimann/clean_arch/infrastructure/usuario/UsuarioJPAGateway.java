package br.com.sulimann.clean_arch.infrastructure.usuario;

import org.springframework.stereotype.Component;

import br.com.sulimann.clean_arch.domain.usuario.Usuario;
import br.com.sulimann.clean_arch.domain.usuario.UsuarioGateway;
import br.com.sulimann.clean_arch.infrastructure.usuario.persistence.UsuarioJPARepository;
import br.com.sulimann.clean_arch.infrastructure.usuario.persistence.UsuarioJpaEntity;

@Component
public class UsuarioJPAGateway implements UsuarioGateway {

  private final UsuarioJPARepository usuarioJPARepository;

  public UsuarioJPAGateway(UsuarioJPARepository usuarioJPARepository) {
    this.usuarioJPARepository = usuarioJPARepository;
  }

  @Override
  public Usuario create(Usuario usuario) {
    return UsuarioJpaEntity.toDomain(usuarioJPARepository.save(UsuarioJpaEntity.fromDomain(usuario)));
  }

  @Override
  public Usuario findById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public void deleteById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }

  @Override
  public Usuario update(Usuario usuario) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

}
