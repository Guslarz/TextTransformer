package pl.put.poznan.transformer.logic;

import java.util.stream.Stream;


public class TextTransformerFactory {

  public static TextTransformer createTextTransformer(String[] transforms) {
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
      case "latex":
        return new LatexFormatTransformer(previous);
      case "applyShortcuts":
        return new ShortcutApplicator(previous);
      default:
        throw new UndefinedTransformException(transform);
    }
  }

  private static TextTransformer combiner(TextTransformer previous,
                                          TextTransformer current) {
    return current;
  }
}
