package br.com.sulimann.command.handler;

import org.springframework.stereotype.Component;

import br.com.sulimann.command.domain.order.CreateOrderCommand;
import br.com.sulimann.command.model.Order;

@Component
public class CreateOrderCommandHandler implements CommandHandler<CreateOrderCommand> {

  @Override
  //@Transactional
  public void handle(CreateOrderCommand command) {
    var order = new Order(command.id(), command.productId(), command.quantity());
    // save order
    // send event
    // log
    System.out.println("Order created: " + order);
  }
}
