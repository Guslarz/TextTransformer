package pl.put.poznan.transformer.logic;

import java.util.List;

public class PolishCharactersTransformer extends ActualTransformer {

  private final PolishCharactersMapper mapper;

  public PolishCharactersTransformer(TextTransformer previous, PolishCharactersMapper mapper) {
    super(previous);
    this.mapper = mapper;
  }

  @Override
  protected String apply(String text) {
    List<String> charactersToReplace = mapper.getCharactersToReplace(text);

    for (String character : charactersToReplace) {
      text = text.replaceAll(character, mapper.getLatinLetter(character));
    }

    return text;
  }
}
