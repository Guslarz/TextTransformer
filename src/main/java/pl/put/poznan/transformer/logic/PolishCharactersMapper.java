package pl.put.poznan.transformer.logic;

import java.util.Set;

public interface PolishCharactersMapper {

  Set<String> getPolishCharacters();

  String getLatinLetter(String polishLetter);
}
