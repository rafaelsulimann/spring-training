package br.com.sulimann.factory_strategy.service;

import org.springframework.stereotype.Service;

import br.com.sulimann.factory_strategy.dto.FreteCalculadoResponse;
import br.com.sulimann.factory_strategy.enums.TipoFrete;
import br.com.sulimann.factory_strategy.utils.factory.FreteStrategyFactory;

@Service
public class CalcularFreteService {

  private final FreteStrategyFactory freteStrategyFactory;

  public CalcularFreteService(FreteStrategyFactory freteStrategyFactory) {
    this.freteStrategyFactory = freteStrategyFactory;
  }

  public FreteCalculadoResponse calcularFrete(String tipoFrete) {
    var valorFrete = freteStrategyFactory.getFreteStrategy(TipoFrete.valueOf(tipoFrete)).calcularFrete();
    return new FreteCalculadoResponse(valorFrete);
  }

}
