package pl.put.poznan.transformer.logic;


public class Reverser extends ActualTransformer {

  public Reverser(TextTransformer previous) {
    super(previous);
  }

  @Override
  protected String apply(String text) {
    return reverseText(text);
  }

  private String reverseText(String text) {
    StringBuilder reversed = new StringBuilder();
    int length = text.length();
    
    for (int i = 0; i < length; i++) {
      if (Character.isUpperCase(text.charAt(i))) {
        reversed.append(Character.toUpperCase(text.charAt(length - i - 1)));
      }
      else {
        reversed.append(Character.toLowerCase(text.charAt(length - i - 1)));
      }
    }

    return reversed.toString();
  }
}

