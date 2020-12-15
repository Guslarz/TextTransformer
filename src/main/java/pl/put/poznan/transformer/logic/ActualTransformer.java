package pl.put.poznan.transformer.logic;

/**
 * Abstrakcyjna klasa dekorator, pozwalająca łączyć klasy z niej
 * dziedziczące w łańcuchy transformacji.
 */
public abstract class ActualTransformer implements TextTransformer {

  private final TextTransformer previous_;

  /**
   * Konstruktor ActualTransformer
   * @param previous TextTransformer, którego transformacja ma nastąpić
   *                 przed obecnym TextTransformerem
   */
  public ActualTransformer(TextTransformer previous) {
    previous_ = previous;
  }

  /**
   * Transformuje rezultat poprzedniej transformacji
   * @param text tekst poddany transformacji
   * @return rezultat transformacji
   */
  @Override
  public String transform(String text) {
    return apply(previous_.transform(text));
  }

  /**
   * Pomocnicza funkcja mogąca zawierać samą transformację (z pominięciem poprzedniej)
   * @param text tekst poddany transformacji
   * @return rezultat transformacji
   */
  protected abstract String apply(String text);
}
