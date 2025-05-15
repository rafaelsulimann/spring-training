package br.com.sulimann.mongodb.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuarios")
public class Usuario {

  @MongoId
  private String id;

  @Indexed(name = "idx_nome")
  private String nome;

  private String email;

  private List<Telefone> telefones;

  @Field(targetType = FieldType.DECIMAL128)
  private BigDecimal salario;

}
