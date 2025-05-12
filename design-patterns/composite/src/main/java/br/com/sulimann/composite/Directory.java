package br.com.sulimann.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
  private String name;
  private List<FileSystemComponent> components = new ArrayList<>();

  public Directory(String name) {
      this.name = name;
  }

  public void addComponent(FileSystemComponent component) {
      components.add(component);
  }

  public void removeComponent(FileSystemComponent component) {
      components.remove(component);
  }

  @Override
  public String getName() {
      return name;
  }

  @Override
  public long getSize() {
      // Calcula o tamanho somando todos os componentes
      return components.stream()
              .mapToLong(FileSystemComponent::getSize)
              .sum();
  }

  @Override
  public void print(String indent) {
      System.out.println(indent + "Diretório: " + name + " (Tamanho total: " + getSize() + " bytes)");

      // Imprime cada componente com recuo adicional
      for (FileSystemComponent component : components) {
          component.print(indent + "  ");
      }
  }
}
