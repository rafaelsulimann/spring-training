package br.com.sulimann.postgres.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "tb_usuarios")
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(onConstructor_ = @__(@Deprecated))
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  private String nome;

  @NonNull
  private String email;

  @NonNull
  private String telefone;

  @NonNull
  private String cpf;

  @NonNull
  private String rg;

  @NonNull
  @Embedded
  private Endereco endereco;

}
