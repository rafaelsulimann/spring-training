package br.com.sulimann.factory_strategy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.factory_strategy.dto.FreteCalculadoRequest;
import br.com.sulimann.factory_strategy.dto.FreteCalculadoResponse;
import br.com.sulimann.factory_strategy.service.CalcularFreteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/frete")
public class CalcularFreteController {

  private final CalcularFreteService calcularFreteService;

  public CalcularFreteController(CalcularFreteService calcularFreteService) {
    this.calcularFreteService = calcularFreteService;
  }

  @GetMapping(value = "/calcular")
  public ResponseEntity<FreteCalculadoResponse> calcularFrete(@Valid FreteCalculadoRequest request) {
    return ResponseEntity.ok(calcularFreteService.calcularFrete(request.tipoFrete()));
  }
}
