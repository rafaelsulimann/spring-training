package br.com.sulimann.command.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.command.bus.CommandBus;
import br.com.sulimann.command.domain.order.CreateOrderCommand;
import br.com.sulimann.command.dto.CreateOrderRequest;
import br.com.sulimann.command.dto.CreateOrderResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
  private final CommandBus commandBus;

  public OrderController(CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  @PostMapping
  public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody @Valid CreateOrderRequest request) {
    var id = UUID.randomUUID();
    commandBus.send(new CreateOrderCommand(id, request.productId(), request.quantity()));
    return ResponseEntity.status(HttpStatus.CREATED).body(new CreateOrderResponse(id));
  }
}
