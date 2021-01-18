package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LatexFormatTransformerTest {
  private LatexFormatTransformer transformer;

  @BeforeEach
  public void setUp() {
    transformer = new LatexFormatTransformer(new InitialText());
  }

  @Test
  public void testApplyAmpersand() {
    assertEquals("hello \\&\\& hi", transformer.apply("hello && hi"));
  }

  @Test
  public void testApplyDollarSign() {
    assertEquals("45\\$ or 54\\$", transformer.apply("45$ or 54$"));
  }

  @Test
  public void testApplyAmpersandAndDollarSign() {
    assertEquals("\\&\\$\\&\\$\\&\\$", transformer.apply("&$&$&$"));
  }

  @Test
  public void testApplyNoLatexSigns() {
    assertEquals("hello world", transformer.apply("hello world"));
  }
}