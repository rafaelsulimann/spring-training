package br.com.sulimann.strategy.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component("IMPORT")
public class ImportTaxStrategyImpl implements TaxStrategy {

  @Override
  public BigDecimal calculate() {
    return new BigDecimal(300);
  }
}
