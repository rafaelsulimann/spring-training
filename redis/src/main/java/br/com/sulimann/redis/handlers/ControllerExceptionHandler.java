package br.com.sulimann.redis.handlers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationErrorDTO> methodArgumentNotValid(MethodArgumentNotValidException e,
      HttpServletRequest request) {
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    ValidationErrorDTO error = new ValidationErrorDTO(LocalDateTime.now(), status.value(), "Dados inválidos",
        request.getRequestURI(), new ArrayList<>());
    for (FieldError f : e.getBindingResult().getFieldErrors()) {
      error.addError(new FieldMessageDTO(f.getField(), f.getDefaultMessage()));
    }
    return ResponseEntity.status(status).body(error);
  }

  public record ValidationErrorDTO(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    LocalDateTime timestamp,
    Integer status,
    String error,
    String path,
    List<FieldMessageDTO> errors
  ) {

    public void addError(FieldMessageDTO error) {
      errors.add(error);
    }
  }

  public record FieldMessageDTO(String field, String message) {
  }

}
