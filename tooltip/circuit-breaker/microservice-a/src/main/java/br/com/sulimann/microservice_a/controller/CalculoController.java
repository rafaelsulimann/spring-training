package br.com.sulimann.microservice_a.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.microservice_a.clients.FreteClient;
import br.com.sulimann.microservice_a.clients.FreteClient.FreteResponse;

@RestController
@RequestMapping(value = "/calculo")
public class CalculoController {

  private final FreteClient freteClient;

  public CalculoController(FreteClient freteClient) {
    this.freteClient = freteClient;
  }

  @GetMapping(value = "/frete/{cep}/retry")
  public ResponseEntity<FreteResponse> calcularFrete(@PathVariable String cep) {
    var freteResponse = this.freteClient.calcularFreteRetry(cep);
    return ResponseEntity.ok(freteResponse);
  }

  @GetMapping(value = "/frete/{cep}/circuit-breaker")
  public ResponseEntity<FreteResponse> calcularFreteCircuitBreaker(@PathVariable String cep) {
    var freteResponse = this.freteClient.calcularFreteCircuitBreaker(cep);
    return ResponseEntity.ok(freteResponse);
  }
}
