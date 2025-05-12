package br.com.sulimann.strategy.dtos;

import jakarta.validation.constraints.NotBlank;

public record TaxRequest(@NotBlank String taxType) {}
