package br.com.sulimann.producer.configs.rabbitmq;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class RabbitmqInitializer {

  public static final String EXCHANGE_NAME = "myExchange";

  @Autowired
  private AmqpAdmin amqpAdmin;

  @PostConstruct
  public void initialize() {
    List<Exchange> exchanges = Arrays.asList(
      ExchangeBuilder.fanoutExchange(EXCHANGE_NAME).durable(true).build()
    );

    exchanges.forEach(exchange -> {
      amqpAdmin.declareExchange(exchange);
    });
  }

}
