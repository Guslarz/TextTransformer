package pl.put.poznan.transformer.logic;


public class ShortcutExpander extends ActualTransformer {

  public ShortcutExpander(TextTransformer previous) {
    super(previous);
  }

  @Override
  protected String apply(String text) {

    for (String key : ShortcutsMap.shortToLong.keySet()) {
      text = expand(text, key);
    }

    return text;
  }

  private String expand(String text, String key) {

    String fullForm = ShortcutsMap.shortToLong.get(key);
    String lowerCase = text.toLowerCase();

    while (lowerCase.contains(key)) {
      StringBuilder oneFullForm = new StringBuilder();
      int index = lowerCase.indexOf(key);
      String shortcut = text.substring(index, index + key.length());

      if (checkUpperCase(shortcut)) {
        fullForm = fullForm.toUpperCase();
      }
      else if (checkCapitalize(shortcut)) {
        fullForm = fullForm.substring(0, 1).toUpperCase() + fullForm.substring(1);
      }
      else {
        fullForm = fullForm.toLowerCase();
      }

      oneFullForm.append(text, 0, index);
      oneFullForm.append(fullForm);
      oneFullForm.append(text, index + key.length(), text.length());

      text = oneFullForm.toString();
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
