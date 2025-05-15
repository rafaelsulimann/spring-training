package br.com.sulimann.clean_arch.infrastructure.usuario.persistence;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor(onConstructor_ = @Deprecated)
public class EnderecoEntity {

  private String rua;
  private String numero;
  private String bairro;
  private String cidade;
  private String estado;
  private String cep;

}
