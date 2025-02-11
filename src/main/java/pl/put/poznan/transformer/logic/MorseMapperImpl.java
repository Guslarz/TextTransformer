package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;
/**
 * Klasa definiująca mapę translacji znaków oraz metody konwersji.
 */
public class MorseMapperImpl implements MorseMapper {

  private static final Map<Character, String> toMorseMap = new HashMap<>() {{
    put('a', ".-");
    put('b', "-...");
    put('c', "-.-");
    put('d', "-..");
    put('e', ".");
    put('f', "..-.");
    put('g', "--.");
    put('h', "....");
    put('i', "..");
    put('j', ".---");
    put('k', "-.");
    put('l', ".-..");
    put('m', "--");
    put('n', "-.");
    put('o', "---");
    put('p', ".--.");
    put('q', "--.-");
    put('r', ".-.");
    put('s', "...");
    put('t', "-");
    put('u', "..-");
    put('v', "...-");
    put('w', ".--");
    put('x', "-..-");
    put('y', "-.--");
    put('z', "--..");
    put('1', ".----");
    put('2', "..---");
    put('3', "...--");
    put('4', "....-");
    put('5', ".....");
    put('6', "-....");
    put('7', "--...");
    put('8', "---..");
    put('9', "----.");
    put('0', "-----");
  }};

  private static final Map<String, Character> toAsciiMap = new HashMap<>() {{
    for (Map.Entry<Character, String> entry : toMorseMap.entrySet()) {
      put(entry.getValue(), entry.getKey());
    }
  }};

  /**
   * Funkcja zwracająca znak Ascii mapowany przez podany ciąg w kodzie Morse'a
   * @param morse ciąg znaków '.' oraz '-'
   * @return pojedynczy znak Ascii
   */
  @Override
  public Character getAscii(String morse) {
    return toAsciiMap.get(morse);
  }

  /**
   * Funkcja zwracająca ciąg w kodzie Morse'a mapowany przez podany znak Ascii
   * @param ascii pojedynczy znak Ascii
   * @return ciąg znaków '.' i '-'
   */
  @Override
  public String getMorse(Character ascii) {
    return toMorseMap.get(ascii);
  }
}
