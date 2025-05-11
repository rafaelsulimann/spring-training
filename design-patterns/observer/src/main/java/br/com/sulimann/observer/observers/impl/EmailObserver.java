package br.com.sulimann.observer.observers.impl;

import org.springframework.stereotype.Component;

import br.com.sulimann.observer.observers.PedidoObserver;

@Component
public class EmailObserver implements PedidoObserver {

  @Override
  public void atualizar() {
    System.out.println("Enviando email para o cliente");
  }
}
