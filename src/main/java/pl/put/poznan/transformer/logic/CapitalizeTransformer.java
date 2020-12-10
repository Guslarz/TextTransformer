package pl.put.poznan.transformer.logic;


public class CapitalizeTransformer extends ActualTransformer {

  public CapitalizeTransformer(TextTransformer previous) {
    super(previous);
  }

  @Override
  protected String apply(String text) {
    return capitalize(text);
  }

  private String capitalize(String text) {

    String result = "";
    String[] words = text.split(" ");

    for (int i = 0; i < words.length; i++) {
      words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
      result = String.join(" ", result, words[i]);
    }

    return result;
  }
}
