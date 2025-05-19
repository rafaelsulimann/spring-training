package br.com.sulimann.rest_client.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import br.com.sulimann.rest_client.dtos.CepResponse;

@Component
public class CepClient {

  private final RestClient restClient;

  public CepClient() {
    this.restClient = RestClient.builder().baseUrl("https://viacep.com.br/ws/").build();
  }

  public CepResponse findCep(String cep) {
    return restClient.get()
      .uri("/{cep}/json", cep)
      .retrieve()
      .body(CepResponse.class);
  }
}
