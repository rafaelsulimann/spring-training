package br.com.sulimann.template;

public abstract class Bebida {
  public final void preparar() {
    if (possuiIngredientes()) {
      adicionarIngredientes();
      fazerBebida();
      return;
    }
    System.out.println("Não foi possível preparar a bebida");
  }

  protected abstract void fazerBebida();

  protected abstract void adicionarIngredientes();

  protected abstract boolean possuiIngredientes();

}
