package pl.put.poznan.transformer.logic;

import java.util.stream.Stream;


/**
 * Fabryka tworząca instancje klasy TextTransformer
 */
public class TextTransformerFactory {

  /**
   * Metoda zwracająca instancję TextTranformer odpowiadającą
   * ciągowi oczekiwanych przez użytkownika transformacji
   *
   * @param transforms kolejne transformacje
   * @return instancja TextTransformer
   */
  public TextTransformer createTextTransformer(String[] transforms) {
    return Stream.of(transforms)
        .reduce(new InitialText(), TextTransformerFactory::accumulator,
            TextTransformerFactory::combiner);
  }

  private static TextTransformer accumulator(TextTransformer previous, String transform) {

    switch (transform) {
      case "upper":
        return new ToUpperTransformer(previous);
      case "lower":
        return new ToLowerTransformer(previous);
      case "capitalize":
        return new CapitalizeTransformer(previous);
      case "reverse":
        return new Reverser(previous);
      case "latex":
        return new LatexFormatTransformer(previous);
      case "applyShortcuts":
        return new ShortcutApplicator(previous);
      case "expandShortcuts":
        return new ShortcutExpander(previous);
      case "numbers":
        return new NumberToWordsTransformer(previous);
      case "removeDuplicates":
        return new DuplicateRemover(previous);
      case "polishLetters":
        return new PolishCharactersTransformer(previous, new PolishCharactersMapperImpl());
      case "morseEncode":
        return new MorseEncoder(previous, new MorseMapperImpl());
      case "morseDecode":
        return new MorseDecoder(previous, new MorseMapperImpl());
      default:
        throw new UndefinedTransformException(transform);
    }
  }

  private static TextTransformer combiner(TextTransformer previous,
                                          TextTransformer current) {
    return current;
  }
}
