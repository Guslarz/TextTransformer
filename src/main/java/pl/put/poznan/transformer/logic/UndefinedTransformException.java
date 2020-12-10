package pl.put.poznan.transformer.logic;


public class UndefinedTransformException extends RuntimeException {

  public UndefinedTransformException(String transform) {
    super(String.format("Transform '%s' is undefined.", transform));
  }
}
