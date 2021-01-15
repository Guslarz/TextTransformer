package pl.put.poznan.transformer.logic;

import java.util.*;

public class PolishCharactersMapperImpl implements PolishCharactersMapper {

  private static final Map<String, String> characters = new HashMap<>() {
    {
      put("ą", "a");
      put("ć", "c");
      put("ę", "e");
      put("ł", "l");
      put("ń", "n");
      put("ó", "o");
      put("ś", "s");
      put("ź", "z");
      put("ż", "z");
      put("Ą", "A");
      put("Ć", "C");
      put("Ę", "E");
      put("Ł", "L");
      put("Ń", "N");
      put("Ó", "O");
      put("Ś", "S");
      put("Ź", "Z");
      put("Ż", "Z");
    }
  };

  @Override
  public String getLatinLetter(String polishLetter) {
    return characters.get(polishLetter);
  }

  @Override
  public Set<String> getPolishCharacters() {
    return characters.keySet();
  }
}
