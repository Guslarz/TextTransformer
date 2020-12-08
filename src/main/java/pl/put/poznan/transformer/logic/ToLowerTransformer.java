package pl.put.poznan.transformer.logic;


public class ToLowerTransformer extends ActualTransformer {

  public ToLowerTransformer(TextTransformer previous) {
    super(previous);
  }

  @Override
  protected String apply(String text){
    return text.toLowerCase();
  }
}
