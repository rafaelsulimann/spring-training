package br.com.sulimann.microservice_b.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/frete")
@Slf4j
public class FreteController {

  @GetMapping(value = "/{cep}")
  public ResponseEntity<FreteResponse> getFrete(@PathVariable String cep) throws InterruptedException {
    log.info("Iniciando busca de frete para o CEP: {}", cep);
    Thread.sleep(10_000);
    log.info("Busca de frete para o CEP: {} finalizada", cep);
    return ResponseEntity.ok(new FreteResponse(new BigDecimal(2500)));
  }

  public record FreteResponse(BigDecimal valor) {
  }

}
