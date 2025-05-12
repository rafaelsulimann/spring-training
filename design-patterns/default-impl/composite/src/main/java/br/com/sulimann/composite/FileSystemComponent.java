package br.com.sulimann.composite;

public interface FileSystemComponent {
  String getName();
  long getSize();
  void print(String indent);
}
