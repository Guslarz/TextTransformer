package pl.put.poznan.transformer.logic;

public interface MorseMapper {

  Character getAscii(String morse);

  String getMorse(Character ascii);
}
