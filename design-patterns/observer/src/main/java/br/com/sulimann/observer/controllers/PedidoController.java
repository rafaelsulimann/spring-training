package br.com.sulimann.observer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.observer.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

  private final PedidoService pedidoService;

  public PedidoController(PedidoService pedidoService) {
    this.pedidoService = pedidoService;
  }

  @PostMapping(value = "/finalizar")
  public ResponseEntity<?> finalizarPedido() {
    pedidoService.finalizarPedido();
    return ResponseEntity.ok().build();
  }
}
