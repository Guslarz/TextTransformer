package pl.put.poznan.transformer.logic;

/**
 * Klasa robiąca zupełnie nic, poza tym że pozwala stworzyć instancję klasy TextTransformer
 * bez modyfikacji tekstu.
 */
public class InitialText implements TextTransformer {

  /**
   * Metoda zupełnie nic nie robi. :)
   * @param text tekst nie podawany transformacji
   * @return ten sam tekst, bo niepoddany transformacji
   */
  public String transform(String text) {
    return text;
  }
}
