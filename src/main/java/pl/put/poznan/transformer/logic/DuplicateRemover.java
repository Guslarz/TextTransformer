package pl.put.poznan.transformer.logic;


public class DuplicateRemover extends ActualTransformer {

  public DuplicateRemover(TextTransformer previous) {
        super(previous);
    }

  @Override
  protected String apply(String text) {
    return removeDuplicates(text);
  }

  private String removeDuplicates(String text) {
    String[] splitted = text.split(" ");
    StringBuilder combined = new StringBuilder(splitted[0]);
    int length = splitted.length;

    for (int i = 1; i < length; i++) {
      if (! splitted[i].equals(splitted[i-1])) {
        combined.append(' ');
        combined.append(splitted[i]);
      }
    }

    return combined.toString();
  }
}