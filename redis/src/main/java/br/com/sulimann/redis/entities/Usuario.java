package br.com.sulimann.redis.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document("usuarios")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

  private String id;

  private String nome;

  private String email;


}
