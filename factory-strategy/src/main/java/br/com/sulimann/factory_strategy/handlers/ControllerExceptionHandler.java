package br.com.sulimann.factory_strategy.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.sulimann.factory_strategy.exceptions.FactoryStrategyException;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(FactoryStrategyException.class)
  public ProblemDetail handlePicPayException(FactoryStrategyException e) {
    return e.toProblemDetail();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    var fieldErrors = e.getFieldErrors()
        .stream()
        .map(fe -> new FieldErrorDetail(fe.getField(), fe.getDefaultMessage()))
        .toList();

    var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

    pb.setTitle("Requisição inválida");
    pb.setProperty("Invalid Params", fieldErrors);

    return pb;
  }

  @ExceptionHandler(Exception.class)
  public ProblemDetail handleException(Exception e) {
    var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

    pb.setTitle("Internal Error");
    pb.setProperty("Error", e.getMessage());

    e.printStackTrace();

    return pb;
  }

  private record FieldErrorDetail(String field, String message) {
  }

}
