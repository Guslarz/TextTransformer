package pl.put.poznan.transformer.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;


class TextTransformerResult {

  private final HttpStatus httpStatus_;
  private final LocalDateTime timestamp_;
  private final String result_;

  public TextTransformerResult(String result, HttpStatus httpStatus) {

    httpStatus_ = httpStatus;
    timestamp_ = LocalDateTime.now();
    result_ = result;
  }

  public int getStatus() {
    return httpStatus_.value();
  }

  public LocalDateTime getTimestamp() {
    return timestamp_;
  }

  public String getResult() {
    return result_;
  }

  public ResponseEntity<TextTransformerResult> toResponseEntity() {
    return new ResponseEntity<>(this, httpStatus_);
  }
}
