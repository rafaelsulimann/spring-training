package br.com.sulimann.observer.observers.impl;

import org.springframework.stereotype.Component;

import br.com.sulimann.observer.observers.PedidoObserver;

@Component
public class NotaFiscalObserver implements PedidoObserver {

  @Override
  public void atualizar() {
    System.out.println("Gerando nota fiscal");
  }
}
