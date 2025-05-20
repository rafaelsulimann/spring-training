package br.com.sulimann.microservice_a.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceAccessException.class)
  public ResponseEntity<Map<String, String>> handleResourceAccessException(ResourceAccessException e) {
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new HashMap<String, String>() {{
      put("message", "Serviço de frete indisponível");
    }});
  }

  @ExceptionHandler(CallNotPermittedException.class)
  public ResponseEntity<Map<String, String>> handleCallNotPermittedException(CallNotPermittedException e) {
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new HashMap<String, String>() {{
      put("message", "Circuito aberto para o serviço de frete, tente novamente mais tarde");
    }});
  }
}
