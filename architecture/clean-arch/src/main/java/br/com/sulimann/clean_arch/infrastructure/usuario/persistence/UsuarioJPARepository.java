package br.com.sulimann.clean_arch.infrastructure.usuario.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJPARepository extends JpaRepository<UsuarioJpaEntity, String> {

}
