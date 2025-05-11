package br.com.sulimann.factory_strategy.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.sulimann.factory_strategy.enums.TipoFrete;
import br.com.sulimann.factory_strategy.utils.factory.FreteStrategy;

@Component
public class TransportadoraFreteService implements FreteStrategy {

  @Override
  public TipoFrete getTipoFrete() {
    return TipoFrete.TRANSPORTADORA;
  }

  @Override
  public BigDecimal calcularFrete() {
    return new BigDecimal(100);
  }

}
