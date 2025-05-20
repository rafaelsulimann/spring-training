package br.com.sulimann.microservice_a.clients;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FreteClient {

  private final RestClient restClient;
  private int attempts = 1;

  public FreteClient(RestTemplate restTemplate) {
    this.restClient = RestClient.builder(restTemplate).baseUrl("http://localhost:8081/frete").build();
  }

  @Retry(name = "retryInstance", fallbackMethod = "fallback")
  public FreteResponse calcularFrete(String cep) {

    log.info("Calculando frete para o CEP: {}", cep);
    log.info("Tentativa: {}", this.attempts);
    this.attempts++;

    var response = this.restClient
    .get()
    .uri("/{cep}", cep)
    .retrieve()
    .body(FreteResponse.class);

    log.info("Frete calculado com sucesso: {}", response);

    return response;

  }

  public record FreteResponse(BigDecimal valor) {}

  public FreteResponse fallback(String cep, Exception e) {
    log.warn("Erro ao calcular frete para o CEP: {}", cep, e);
    return new FreteResponse(BigDecimal.ZERO);
  }

}
