package br.com.sulimann.rest_client.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;

public record CepResponse(
  String cep,
  String logradouro,
  String complemento,
  String bairro,
  @JsonAlias("localidade")
  String cidade,
  String uf,
  String estado,
  String ddd
) {
}
