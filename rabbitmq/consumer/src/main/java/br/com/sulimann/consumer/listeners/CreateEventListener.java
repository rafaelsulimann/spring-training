package br.com.sulimann.consumer.listeners;

import static br.com.sulimann.consumer.configs.rabbitmq.RabbitmqInitializer.QUEUE1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import br.com.sulimann.consumer.dtos.CreateEventRequest;

@Component
public class CreateEventListener {

  private final Logger logger = LoggerFactory.getLogger(CreateEventListener.class);

  @RabbitListener(queues = QUEUE1)
  public void listen(Message<CreateEventRequest> message) {
    logger.info("Received message: {}", message);
  }
}
