package br.com.sulimann.observer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sulimann.observer.observers.PedidoObserver;

@Service
public class PedidoService {

  private final List<PedidoObserver> observers = new ArrayList<>();

  public PedidoService(List<PedidoObserver> observers) {
    this.observers.addAll(observers);
  }

  public void finalizarPedido() {
    System.out.println("Finalizando pedido");
    notifyObservers();
  }

  private void notifyObservers() {
    this.observers.forEach(PedidoObserver::atualizar);
  }

}
