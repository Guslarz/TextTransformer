package pl.put.poznan.transformer.logic;


import java.util.HashMap;
import java.util.Map;

public class ShortcutsMap {

  public static Map<String, String> longToShort = new HashMap<>() {
    {
      put("na przykład", "np.");
      put("między innymi", "m.in.");
      put("i tym podobne", "itp.");
      put("i tak dalej", "itd.");
    }
  };

  public static Map<String, String> shortToLong = new HashMap<>() {
    {
      put("prof.", "profesor");
      put("dr", "doktor");
      put("np.", "na przykład");
      put("m.in.", "między innymi");
      put("itd.", "i tak dalej");
      put("itp.", "i tym podobne");
    }
  };

}
