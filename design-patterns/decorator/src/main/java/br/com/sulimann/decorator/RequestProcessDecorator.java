package br.com.sulimann.decorator;

public abstract class RequestProcessDecorator implements RequestProcessor {

  protected RequestProcessor processor;

  public RequestProcessDecorator(RequestProcessor processor) {
    this.processor = processor;
  }

  @Override
  public void process(Request request) {
    processor.process(request);
  }
}
