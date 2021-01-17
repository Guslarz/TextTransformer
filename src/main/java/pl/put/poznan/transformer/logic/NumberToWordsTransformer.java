package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberToWordsTransformer extends ActualTransformer {

  public NumberToWordsTransformer(TextTransformer previous) {
    super(previous);
  }

  @Override
  protected String apply(String text) {
    Matcher matcher = pattern.matcher(text);
    return matcher.replaceAll(NumberToWordsTransformer::convertNumbersToWords);
  }

  private static final String[] ones = {
          "zero", "jeden", "dwa", "trzy", "cztery",
          "pięć", "sześć", "siedem", "osiem", "dziewięć"
  };

  private static final String[] teens = {
          "dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście",
          "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"
  };

  private static final String[] tens = {
          "", "dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt",
          "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"
  };

  private static final String[] hundreds = {
          "", "sto", "dwieście", "trzysta", "czterysta", "pięćset",
          "sześćset", "siedemset", "osiemset", "dziewięćset", "tysiąc"
  };

  private static final String[] fractions = {
          "dziesiąta", "dziesiąte", "dziesiątych", "setna", "setne", "setnych"
  };

  private static final String[] fractionsNumbers = {
          "", "jedna", "dwie", "trzy", "cztery",
          "pięć", "sześć", "siedem", "osiem", "dziewięć"
  };

  private static final Pattern pattern = Pattern.compile("\\d+(:?[.,]\\d+)?");

  private static String convertNumbersToWords(MatchResult mr) {

    String number = mr.group();
    String result = "";

    if (number.matches("\\d+,\\d+")) {
      number = number.replace(',','.');
    }

    if (Float.parseFloat(number) > 1000) {
      return number;
    }

    if (number.matches("\\d+[.,]\\d+")) {
      String[] numbers = number.split("[.,]");
      if (Integer.parseInt(numbers[1]) > 99) {
        return number;
      }
      result += transformNumber(numbers[0], false);
      if (!numbers[1].matches("0{1,2}")) {
        result += " i ";
      }
      result += transformNumber(numbers[1], true);
    } else {
      result += transformNumber(number, false);
    }

    return result;
  }

  private static String transformNumber(String number, boolean isFraction) {

    List<String> result = new ArrayList<>();
    int numberInt = Integer.parseInt(number),
            length = number.length(), tmp = 0, tmp2 = 0;

    if (numberInt == 1000) {
      return hundreds[10];
    }

    if (length > 0) {
      tmp = numberInt % 10;
      numberInt /= 10;

      if (isFraction) {
        if (length == 2 && tmp == 1 && numberInt != 0) {
          result.add(ones[tmp]);
        } else {
          result.add(fractionsNumbers[tmp]);
        }
      } else {
        result.add(ones[tmp]);
      }
    }

    if (isFraction && length == 1) {
      if (tmp == 1) {
        result.add(fractions[0]);
      } else if (tmp > 1 && tmp < 5) {
        result.add(fractions[1]);
      } else if (tmp != 0) {
        result.add(fractions[2]);
      }
    }

    if (length > 1) {
      tmp2 = numberInt % 10;
      numberInt /= 10;

      if (tmp2 == 1) {
        result.clear();
        result.add(teens[tmp]);
      } else if (tmp == 0) {
        result.clear();
        result.add(tens[tmp2]);
      } else {
        result.add(0, tens[tmp2]);
      }
    }

    if (isFraction && length == 2) {
      if (tmp == 1 && tmp2 == 0) {
        result.add(fractions[3]);
      } else if (tmp > 1 && tmp < 5) {
        result.add(fractions[4]);
      } else if (tmp != 0 && tmp2 != 0) {
        result.add(fractions[5]);
      }
    }

    if (length > 2) {
      tmp = numberInt % 10;
      result.add(0, hundreds[tmp]);
    }

    return result.stream()
            .filter(str -> !str.isEmpty())
            .collect(Collectors.joining(" "));
  }
}