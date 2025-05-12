package br.com.sulimann.template;

import java.util.Random;

public class Cerveja extends Bebida {

  @Override
  protected void fazerBebida() {
    System.out.println("Fazendo cerveja");
  }

  @Override
  protected void adicionarIngredientes() {
    System.out.println("Adicionando cerveja");
  }

  @Override
  protected boolean possuiIngredientes() {
    return new Random().nextBoolean();
  }

}
