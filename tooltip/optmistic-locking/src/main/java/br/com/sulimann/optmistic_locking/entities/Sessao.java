package br.com.sulimann.optmistic_locking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "tb_sessions")
@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@Getter
public class Sessao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  private String filme;

  @NonNull
  private Integer anoLancamento;

  @NonNull
  private Integer quantidade;

  @Version
  private long version; // para otimistic locking

  public void atualizarQuantidade(int i) {
    if(i < 0) {
      throw new IllegalArgumentException("A quantidade não pode ser negativa");
    }

    this.quantidade = i;
  }
}
