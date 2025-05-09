package br.com.sulimann.factory_strategy.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.sulimann.factory_strategy.enums.TipoFrete;
import br.com.sulimann.factory_strategy.utils.factory.FreteStrategy;

@Component
public class SedexFreteService implements FreteStrategy {

  @Override
  public TipoFrete getTipoFrete() {
    return TipoFrete.SEDEX;
  }

  @Override
  public BigDecimal calcularFrete() {
    return new BigDecimal(300);
  }

}
