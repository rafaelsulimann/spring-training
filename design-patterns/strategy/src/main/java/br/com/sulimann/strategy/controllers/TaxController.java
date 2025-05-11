package br.com.sulimann.strategy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.strategy.dtos.TaxRequest;
import br.com.sulimann.strategy.dtos.TaxResponse;
import br.com.sulimann.strategy.services.TaxService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tax")
public class TaxController {

  private final TaxService taxService;

  public TaxController(TaxService taxService) {
    this.taxService = taxService;
  }

  @GetMapping(value = "/calculate")
  public ResponseEntity<TaxResponse> calculateTax(@Valid TaxRequest request) {
    return ResponseEntity.ok(new TaxResponse(taxService.calculateTax(request)));
  }
}
