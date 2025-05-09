package br.com.sulimann.factory_strategy.utils.factory;

import java.math.BigDecimal;

import br.com.sulimann.factory_strategy.enums.TipoFrete;

public interface FreteStrategy {
  TipoFrete getTipoFrete();
  BigDecimal calcularFrete();
}
