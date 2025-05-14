package br.com.sulimann.open_feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.sulimann.open_feign.dtos.CepResponse;

@FeignClient(name = "cepClient", url = "https://viacep.com.br/ws")
public interface CepClient {

  @GetMapping(value = "/{cep}/json")
  CepResponse getCep(@PathVariable String cep);

}
