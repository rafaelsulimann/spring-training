package br.com.sulimann.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.producer.dtos.CreateEventRequest;
import br.com.sulimann.producer.services.KafkaProducerService;
import br.com.sulimann.utils.JSONUtilities;

@RestController
@RequestMapping(value = "/events")
public class EventController {

  @Autowired
  private KafkaProducerService kafkaProducerService;

  @PostMapping
  public ResponseEntity<String> sendEvent(@RequestBody CreateEventRequest event) {
    var topicName = "create-event";
    var message = JSONUtilities.create().withParseLocalDate().toJson(event);
    this.kafkaProducerService.enviarMensagem(topicName, message, null);
    return ResponseEntity.ok().build();
  }
}
