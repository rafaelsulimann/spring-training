package br.com.sulimann.producer.controller;

import static br.com.sulimann.producer.configs.rabbitmq.RabbitmqInitializer.EXCHANGE_NAME;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.producer.dtos.CreateEventRequest;

@RestController
@RequestMapping("/events")
public class EventController {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @PostMapping
  public String sendEvent(@RequestBody CreateEventRequest event) {
    rabbitTemplate.convertAndSend(EXCHANGE_NAME, "", event);
    return "Event sent successfully";
  }

}
