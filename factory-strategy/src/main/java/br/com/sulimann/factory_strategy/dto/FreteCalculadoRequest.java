package br.com.sulimann.factory_strategy.dto;

import br.com.sulimann.factory_strategy.enums.TipoFrete;
import br.com.sulimann.factory_strategy.utils.validators.ValidEnum;
import jakarta.validation.constraints.NotBlank;

public record FreteCalculadoRequest (
  @NotBlank
  @ValidEnum(enumClass = TipoFrete.class, message = "Tipo Frete inválido")
  String tipoFrete
){}
