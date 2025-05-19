package br.com.sulimann.microservice_a.clients;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Component
public class FreteClient {

  private final RestClient restClient;

  public FreteClient(RestTemplate restTemplate) {
    this.restClient = RestClient.builder(restTemplate).baseUrl("http://localhost:8081/frete").build();
  }

  public FreteResponse calcularFrete(String cep) {
    return this.restClient
    .get()
    .uri("/{cep}", cep)
    .retrieve()
    .body(FreteResponse.class);

  }

  public record FreteResponse(BigDecimal valor) {}

}
