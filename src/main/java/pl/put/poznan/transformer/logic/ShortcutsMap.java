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

}
