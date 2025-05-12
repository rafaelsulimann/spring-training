package br.com.sulimann.factory_strategy.utils.factory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.sulimann.factory_strategy.enums.TipoFrete;

@Service
public class FreteStrategyFactory {

  private final Map<TipoFrete, FreteStrategy> freteStrategies;

  public FreteStrategyFactory(List<FreteStrategy> freteStrategies) {
    this.freteStrategies = freteStrategies.stream()
        .collect(Collectors.toMap(FreteStrategy::getTipoFrete, Function.identity()));
  }

  public FreteStrategy getFreteStrategy(TipoFrete tipoFrete) {
    FreteStrategy freteStrategy = freteStrategies.get(tipoFrete);
    if (freteStrategy == null) {
      throw new IllegalArgumentException("Tipo de frete não suportado: " + tipoFrete);
    }
    return freteStrategy;
  }

}
