package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberToWordsTransformerTest {
  private NumberToWordsTransformer transformer;

  @BeforeEach
  public void setUp() {
    transformer = new NumberToWordsTransformer(new InitialText());
  }

  @Test
  public void testApplyOnes() {
    assertEquals("trzy i osiem i pięć", transformer.apply("3 i 8 i 5"));
  }

  @Test
  public void testApplyTeens() {
    assertEquals("dwanaście i siedemnaście", transformer.apply("12 i 17"));
  }

  @Test
  public void testApplyTens() {
    assertEquals("czterdzieści pięć i dziewięćdziesiąt dwa", transformer.apply("45 i 92"));
  }

  @Test
  public void testApplyHundreds() {
    assertEquals("sto sześćdziesiąt cztery i siedemset pięćdziesiąt jeden",
            transformer.apply("164 i 751"));
  }

  @Test
  public void testApplyFractionPointSeparator() {
    assertEquals("dwadzieścia cztery i osiemdziesiąt dwie setne", transformer.apply("24.82"));
  }

  @Test
  public void testApplyFractionCommaSeparator() {
    assertEquals("jedenaście i sześćdziesiąt dziewięć setnych", transformer.apply("11,69"));
  }

  @Test
  public void testApplyBoundary() {
    assertEquals("zero i tysiąc", transformer.apply("0 i 1000"));
  }

  @Test
  public void testApplyOutOfRange() {
    assertEquals("1234", transformer.apply("1234"));
  }

  @Test
  public void testApplyFractionOutOfRange() {
    assertEquals("12.345", transformer.apply("12.345"));
  }

  @Test
  public void testApplyNumberInsideText() {
    assertEquals("blapięćdziesiątbla i .dwieście.", transformer.apply("bla50bla i .200."));
  }
}
