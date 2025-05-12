package br.com.sulimann.decorator;

public class BaseRequestProcessor implements RequestProcessor {

  @Override
  public void process(Request request) {
    System.out.println("Request processed successfully");
  }
}
