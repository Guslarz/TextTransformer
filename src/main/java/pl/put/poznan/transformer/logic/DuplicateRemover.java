package pl.put.poznan.transformer.logic;

/**
 * Klasa umozliwiająca transformację tekstu poprzez usuwanie duplikujących się w nim wyrażeń
 */
public class DuplicateRemover extends ActualTransformer {

  public DuplicateRemover(TextTransformer previous) {
        super(previous);
    }

  /**
   * Funkcja usuwająca zduplikowane wyrażenia znajdujące się bezpośrednio po sobie,
   * oddzielone pustym znakiem ' '.
   * @param text tekst poddany transformacji
   * @return rezultat transformacji
   */
  @Override
  protected String apply(String text) {
    return removeDuplicates(text);
  }

  private String removeDuplicates(String text) {
    String[] split = text.split(" ");
    StringBuilder combined = new StringBuilder(split[0]);
    int length = split.length;

    for (int i = 1; i < length; i++) {
      if (!split[i].equals(split[i-1])) {
        combined.append(' ');
        combined.append(split[i]);
      }
    }

    return combined.toString();
  }
}