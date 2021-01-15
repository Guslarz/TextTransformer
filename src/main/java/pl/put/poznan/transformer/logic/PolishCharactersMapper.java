package pl.put.poznan.transformer.logic;

import java.util.List;

public interface PolishCharactersMapper {

  List<String> getCharactersToReplace(String text);

  String getLatinLetter(String polishLetter);
}
