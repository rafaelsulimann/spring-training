package br.com.sulimann.mongodb.dtos;

import java.math.BigDecimal;
import java.util.List;

import br.com.sulimann.mongodb.entities.Telefone;

public record CreateUserResponse(String id, String nome, String email, List<Telefone> telefones, BigDecimal salario) {

}
