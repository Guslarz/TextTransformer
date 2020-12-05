package pl.put.poznan.transformer.logic;


public class ToUpperTransformer extends ActualTransformer {

  public ToUpperTransformer(TextTransformer previous) { super(previous); }

  @Override
  protected String apply(String text) {
    return text.toUpperCase();
  }
}
