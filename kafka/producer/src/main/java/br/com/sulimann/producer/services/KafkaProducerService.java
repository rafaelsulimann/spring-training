package br.com.sulimann.producer.services;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensagem(final String topicName, final String message, BiConsumer<SendResult<String, String>, Throwable> callback) {
      ProducerRecord<String, String> records = new ProducerRecord<>(topicName, message);
      records.headers().add("kafka_topic", topicName.getBytes());
      CompletableFuture<SendResult<String, String>> completableFuture = this.kafkaTemplate.send(records);
      completableFuture.whenComplete(Objects.nonNull(callback) ? callback : (result, ex) -> {
        if (Objects.nonNull(ex)) {
          System.out.println("Erro ao enviar mensagem: " + ex.getMessage());
        } else {
          System.out.println("Mensagem enviada com sucesso: " + result.getProducerRecord().value());
        }
      });
    }

}
