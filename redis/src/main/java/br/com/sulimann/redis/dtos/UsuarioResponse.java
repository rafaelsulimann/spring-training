package br.com.sulimann.redis.dtos;

import java.io.Serializable;

import br.com.sulimann.redis.entities.Usuario;

public record UsuarioResponse(String id, String nome, String email) implements Serializable{

  public UsuarioResponse(Usuario usuario) {
    this(usuario.getId(), usuario.getNome(), usuario.getEmail());
  }

}
