package br.com.sulimann.redis.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CriarUsuarioRequest(
  @NotBlank(message = "Nome é obrigatório")
  String nome,

  @NotBlank(message = "Email é obrigatório")
  @Email(message = "Email inválido")
  String email
) {

}
