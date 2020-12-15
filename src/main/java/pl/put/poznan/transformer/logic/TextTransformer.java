package pl.put.poznan.transformer.logic;

/**
 * Interfejs, na którym opiera się działanie programu i implementacja wzorca Dekorator.
 */
public interface TextTransformer {

  /**
   * Metoda transformująca w pewien sposób przekazany jej tekst.
   * @param text tekst poddany transformacji
   * @return rezultat transformacji
   */
  String transform(String text);
}
