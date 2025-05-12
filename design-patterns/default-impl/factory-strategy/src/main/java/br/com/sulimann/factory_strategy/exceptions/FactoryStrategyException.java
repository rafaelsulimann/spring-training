package br.com.sulimann.factory_strategy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class FactoryStrategyException extends RuntimeException {

  public ProblemDetail toProblemDetail(){
    var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

    pb.setTitle("Factory Strategy Internal Error");

    return pb;
  }
}
