package br.com.sulimann.microservice_a.clients;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
  public FreteResponse calcularFreteRetry(String cep) {

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

  @CircuitBreaker(name = "circuitbreakerInstance")
  public FreteResponse calcularFreteCircuitBreaker(String cep) {

    log.info("Tentativa: {}", this.attempts);
    this.attempts++;

    var response = this.restClient
        .get()
        .uri("/{cep}", cep)
        .retrieve()
        .body(FreteResponse.class);

    return response;
  }

  public record FreteResponse(BigDecimal valor) {
  }

  public FreteResponse fallback(String cep, Exception e) {
    return new FreteResponse(BigDecimal.ZERO);
  }

}
