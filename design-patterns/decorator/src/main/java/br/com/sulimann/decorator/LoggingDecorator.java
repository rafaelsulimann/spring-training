package br.com.sulimann.decorator;

public class LoggingDecorator extends RequestProcessDecorator {

  public LoggingDecorator(RequestProcessor processor) {
    super(processor);
  }

  @Override
  public void process(Request request) {
    System.out.println("Logging request: " + request);
    super.process(request);
  }


}
