package pl.put.poznan.transformer.logic;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rot13Transformer extends ActualTransformer {

  private final Rot13Mapper mapper;

  public Rot13Transformer(TextTransformer previous, Rot13Mapper mapper) {
    super(previous);
    this.mapper = mapper;
  }

  @Override
  protected String apply(String text) {
    return Stream.of(text.split(" "))
            .map(this::mapWord)
            .collect(Collectors.joining(" "));
  }

  private String mapWord(String word) {
    return word.chars()
            .mapToObj(i -> (char) i)
            .map(mapper::getCodedLetter)
            .collect(Collector.of(StringBuilder::new,
                    StringBuilder::append,
                    StringBuilder::append,
                    StringBuilder::toString));
  }
}
