package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class Rot13MapperImpl implements Rot13Mapper {

  private static final Map<Character, Character> rot13Map = new HashMap<>() {{
    for (Character c = 'a'; c <= 'z'; c++) {
      Character encoded = (char)((c - 'a' + 13) % 26 + 'a');
      put(c, encoded);
      put(Character.toUpperCase(c), Character.toUpperCase(encoded));
    }
  }};

  @Override
  public Character getCodedLetter(Character inputLetter) {
    return rot13Map.getOrDefault(inputLetter, inputLetter);
  }
}
