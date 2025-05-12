package br.com.sulimann.decorator;

public class ValidationDecorator extends RequestProcessDecorator {

  public ValidationDecorator(RequestProcessor processor) {
    super(processor);
  }

  @Override
  public void process(Request request) {
    validate(request);
    super.process(request);
  }

  private void validate(Request request) {
    if (request.ip() == null || request.ip().isEmpty()) {
      throw new IllegalArgumentException("IP is required");
    }
    if (request.headers() == null || request.headers().isEmpty()) {
      throw new IllegalArgumentException("Headers are required");
    }
  }
}
