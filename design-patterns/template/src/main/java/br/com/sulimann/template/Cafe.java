package br.com.sulimann.template;

import java.util.Random;

public class Cafe extends Bebida {

  @Override
  protected void fazerBebida() {
    System.out.println("Fazendo cafe");
  }

  @Override
  protected void adicionarIngredientes() {
    System.out.println("Adicionando cafe");
  }

  @Override
  protected boolean possuiIngredientes() {
    return new Random().nextBoolean();
  }

}
