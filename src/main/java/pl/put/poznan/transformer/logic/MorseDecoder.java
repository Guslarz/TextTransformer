package pl.put.poznan.transformer.logic;

import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorseDecoder extends ActualTransformer {

  private final MorseMapper mapper;

  public MorseDecoder(TextTransformer previous, MorseMapper mapper) {
    super(previous);
    this.mapper = mapper;
  }

  @Override
  protected String apply(String text) {
    return Stream.of(text.split(" {3}"))
        .map(this::mapWord)
        .collect(Collectors.joining(" "));
  }

  private String mapWord(String word) {
    return Stream.of(word.split(" "))
        .map(mapper::getAscii)
        .filter(Objects::nonNull)
        .collect(Collector.of(StringBuilder::new,
            StringBuilder::append,
            StringBuilder::append,
            StringBuilder::toString));
  }
}

