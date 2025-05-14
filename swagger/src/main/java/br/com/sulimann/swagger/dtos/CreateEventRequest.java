package br.com.sulimann.swagger.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateEventRequest(
  @Schema(description = "Nome do evento")
  @NotBlank(message = "Nome do evento é obrigatório")
  @Size(min = 3, max = 100, message = "Nome do evento deve ter entre 3 e 100 caracteres")
  String name,
  @Schema(description = "Descrição do evento")
  @NotBlank(message = "Descrição do evento é obrigatório")
  @Size(min = 3, max = 100, message = "Descrição do evento deve ter entre 3 e 100 caracteres")
  String description) {

}
