package br.com.sulimann.clean_arch.domain.usuario;

public interface UsuarioGateway {
  Usuario create(Usuario usuario);
  Usuario findById(String id);
  void deleteById(String id);
  Usuario update(Usuario usuario);
}
