package br.com.sulimann.observer.observers.impl;

import org.springframework.stereotype.Component;

import br.com.sulimann.observer.observers.PedidoObserver;

@Component
public class EstoqueObserver implements PedidoObserver {

  @Override
  public void atualizar() {
    System.out.println("Atualizando estoque");
  }
}
