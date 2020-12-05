package pl.put.poznan.transformer.logic;


public abstract class ActualTransformer implements TextTransformer {

  private final TextTransformer previous_;

  public ActualTransformer(TextTransformer previous) {
    previous_ = previous;
  }

  @Override
  public String transform(String text) {
    return apply(previous_.transform(text));
  }

  protected abstract String apply(String text);
}
