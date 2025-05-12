package br.com.sulimann.strategy.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component("INCOME")
public class IncomeTaxStrategyImpl implements TaxStrategy {

  @Override
  public BigDecimal calculate() {
    return new BigDecimal(100);
  }
}
