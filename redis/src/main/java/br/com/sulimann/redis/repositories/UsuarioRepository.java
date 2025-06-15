package br.com.sulimann.redis.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.sulimann.redis.entities.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

  Optional<Usuario> findByEmail(String email);

}
