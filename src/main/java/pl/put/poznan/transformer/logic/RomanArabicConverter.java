package pl.put.poznan.transformer.logic;

import java.util.TreeMap;

public class RomanArabicConverter extends ActualTransformer {

  private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
  static {
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");
  }

  public RomanArabicConverter(TextTransformer previous) {
    super(previous);
  }

  @Override
  protected String apply(String text) {
    String[] split = text.split(" ");
    for (int i = 0; i < split.length; i++) {
      try {
        int numeric = Integer.parseInt(split[i]);
        if (numeric > 0){
          split[i] = arabicToRoman(numeric);
        }
      }
      catch (NumberFormatException ignored) {}
    }
    return String.join(" ", split);
  }

  private static String arabicToRoman(int number) {
    int k =  map.floorKey(number);
    if ( number == k) {
      return map.get(number);
    }
    return map.get(k) + arabicToRoman(number- k);
  }
}
