package pl.put.poznan.transformer.logic;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorseEncoder extends ActualTransformer {

  private final MorseMapper mapper;

  public MorseEncoder(TextTransformer previous, MorseMapper mapper) {
    super(previous);
    this.mapper = mapper;
  }

  @Override
  protected String apply(String text) {
    return Stream.of(text.toLowerCase().split(" "))
        .map(this::mapWord)
        .collect(Collectors.joining("   "));
  }

  private String mapWord(String word) {
    return word.chars()
        .mapToObj(i -> (char) i)
        .map(mapper::getMorse)
        .filter(Objects::nonNull)
        .collect(Collectors.joining(" "));
  }
}
