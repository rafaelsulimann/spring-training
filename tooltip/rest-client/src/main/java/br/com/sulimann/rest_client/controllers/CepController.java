package br.com.sulimann.rest_client.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.rest_client.clients.CepClient;
import br.com.sulimann.rest_client.dtos.CepResponse;

@RestController
@RequestMapping("/cep")
public class CepController {

  private final CepClient cepClient;

  public CepController(CepClient cepClient) {
    this.cepClient = cepClient;
  }

  @GetMapping("/{cep}")
  public ResponseEntity<CepResponse> findCep(@PathVariable String cep) {
    return ResponseEntity.ok(cepClient.findCep(cep));
  }
}
