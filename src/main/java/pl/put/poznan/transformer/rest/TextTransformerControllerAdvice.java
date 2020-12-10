package pl.put.poznan.transformer.rest;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import pl.put.poznan.transformer.logic.UndefinedTransformException;

import java.util.Map;


@RestControllerAdvice
public class TextTransformerControllerAdvice {

  @ExceptionHandler({ UndefinedTransformException.class })
  public ResponseEntity<Map<String, Object>> undefinedTransformHandler(
      UndefinedTransformException ex, WebRequest request) {

    Map<String, Object> attributes = new DefaultErrorAttributes()
        .getErrorAttributes(request, ErrorAttributeOptions.defaults());
    HttpStatus status = HttpStatus.BAD_REQUEST;
    attributes.replace("status", status.value());
    attributes.replace("error", status.getReasonPhrase());
    attributes.replace("message", ex.getLocalizedMessage());

    return new ResponseEntity<>(attributes, status);
  }
}
