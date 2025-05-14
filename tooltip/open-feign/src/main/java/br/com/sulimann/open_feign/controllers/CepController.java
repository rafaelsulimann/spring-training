package br.com.sulimann.open_feign.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.open_feign.clients.CepClient;
import br.com.sulimann.open_feign.dtos.CepResponse;

@RestController
@RequestMapping(value = "/cep")
public class CepController {

  private final CepClient cepClient;

  public CepController(CepClient cepClient) {
    this.cepClient = cepClient;
  }

  @GetMapping(value = "/{cep}")
  public ResponseEntity<CepResponse> getCep(@PathVariable String cep) {
    return ResponseEntity.ok(this.cepClient.getCep(cep));
  }

}
