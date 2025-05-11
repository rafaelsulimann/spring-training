package br.com.sulimann.strategy.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component("SALES")
public class SalesTaxStrategyImpl implements TaxStrategy {

  @Override
  public BigDecimal calculate() {
    return new BigDecimal(200);
  }
}
