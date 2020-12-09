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
    String lowerCase = text.toLowerCase();

    while (lowerCase.contains(key)) {
      StringBuilder oneShortcut = new StringBuilder();
      int index = lowerCase.indexOf(key);
      String fullForm = text.substring(index, index + key.length());

      if (checkUpperCase(fullForm)) {
        shortcut = shortcut.toUpperCase();
      }
      else if (checkCapitalize(fullForm)) {
        shortcut = shortcut.substring(0, 1).toUpperCase() + shortcut.substring(1).toLowerCase();
      }
      else {
        shortcut = shortcut.toLowerCase();
      }

      oneShortcut.append(text, 0, index);
      oneShortcut.append(shortcut);
      oneShortcut.append(text, index + key.length(), text.length());

      text = oneShortcut.toString();
      lowerCase = text.toLowerCase();
    }

    return text;
  }

  private Boolean checkCapitalize(String text) {
    return Character.isUpperCase(text.charAt(0));
  }

  private Boolean checkUpperCase(String text) {
    return text.equals(text.toUpperCase());
  }
}