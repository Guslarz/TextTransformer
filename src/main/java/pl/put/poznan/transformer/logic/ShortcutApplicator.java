package pl.put.poznan.transformer.logic;


public class ShortcutApplicator extends ActualTransformer{

  public ShortcutApplicator(TextTransformer previous) {
    super(previous);
  }

  @Override
  protected String apply(String text) {

    for (String key : ShortcutsMap.longToShort.keySet()) {
      text = shorten(text, key);
    }

    return text;
  }

  private String shorten(String text, String key) {

    String shortcut = ShortcutsMap.longToShort.get(key);

    while (text.contains(key)) {
      text = text.substring(0, text.indexOf(key)) + shortcut + text.substring(text.indexOf(key) + key.length());
    }

    return text;
  }

}
