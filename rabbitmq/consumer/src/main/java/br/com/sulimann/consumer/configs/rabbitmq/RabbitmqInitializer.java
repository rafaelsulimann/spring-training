package br.com.sulimann.consumer.configs.rabbitmq;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class RabbitmqInitializer {

  public static final String QUEUE1 = "queue1";
  public static final String QUEUE2 = "queue2";
  public static final String QUEUE3 = "queue3";

  public static final String EXCHANGE_NAME = "myExchange";

  @Autowired
  private AmqpAdmin amqpAdmin;

  @PostConstruct
  public void initialize() {
    // Exchanges
    FanoutExchange fanoutExchange = ExchangeBuilder.fanoutExchange(EXCHANGE_NAME).durable(true).build();

    // Queues
    Queue queue1 = QueueBuilder.durable(QUEUE1).build();
    Queue queue2 = QueueBuilder.durable(QUEUE2).build();
    Queue queue3 = QueueBuilder.durable(QUEUE3).build();

    // Bindings
    Binding binding1 = BindingBuilder.bind(queue1).to(fanoutExchange);
    Binding binding2 = BindingBuilder.bind(queue2).to(fanoutExchange);
    Binding binding3 = BindingBuilder.bind(queue3).to(fanoutExchange);

    // Declare queues
    List<Queue> queues = Arrays.asList(queue1, queue2, queue3);
    queues.forEach(queue -> {
      amqpAdmin.declareQueue(queue);
    });

    // Declare exchanges
    List<Exchange> exchanges = Arrays.asList(fanoutExchange);
    exchanges.forEach(exchange -> {
      amqpAdmin.declareExchange(exchange);
    });

    // Declare bindings
    List<Binding> bindings = Arrays.asList(binding1, binding2, binding3);
    bindings.forEach(binding -> {
      amqpAdmin.declareBinding(binding);
    });
  }
}
