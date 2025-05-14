package br.com.sulimann.consumer.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CreateEventConsumer {

  private final Logger logger = LoggerFactory.getLogger(CreateEventConsumer.class);

  @KafkaListener(topics = "create-event", groupId = "group-id")
  public void listen(String message) {
    logger.info("Mensagem recebida: {}", message);
  }
}
