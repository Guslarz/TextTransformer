package pl.put.poznan.transformer.logic;

public class PolishCharactersTransformer extends ActualTransformer {

  private final PolishCharactersMapper mapper;

  public PolishCharactersTransformer(TextTransformer previous, PolishCharactersMapper mapper) {
    super(previous);
    this.mapper = mapper;
  }

  @Override
  protected String apply(String text) {
    for (String character : mapper.getPolishCharacters()) {
      text = text.replaceAll(character, mapper.getLatinLetter(character));
    }

    return text;
  }
}
