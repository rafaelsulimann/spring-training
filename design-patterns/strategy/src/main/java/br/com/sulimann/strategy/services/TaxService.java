package br.com.sulimann.strategy.services;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.sulimann.strategy.dtos.TaxRequest;

@Service
public class TaxService {

  private final Map<String, TaxStrategy> taxStrategies;

  public TaxService(Map<String, TaxStrategy> taxStrategies) {
    this.taxStrategies = taxStrategies;
  }

  public BigDecimal calculateTax(TaxRequest request) {
    return taxStrategies.get(request.taxType()).calculate();
  }
}
