package pl.put.poznan.transformer.logic;

/**
 * Interfejs dostarczający metody translacji znaków w kodzie morsa i ascii.
 */
public interface MorseMapper {

  /**
   *
   * @param morse ciąg znaków, powinien składać się ze znaków '.' oraz '-'
   * @return pojedynczy znak w Ascii
   */
  Character getAscii(String morse);

  /**
   *
   * @param ascii pojedynczy znak Ascii
   * @return ciąg znaków, składający się ze znaków '.' oraz '-'
   */
  String getMorse(Character ascii);
}
