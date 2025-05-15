package br.com.sulimann.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.sulimann.mongodb.entities.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, Long> {

}
