package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverserTest {
  private Reverser transformer;

  @BeforeEach
  public void setUp() {
    transformer = new Reverser(new InitialText());
  }

  @Test
  public void testApplyLowerCase() {
    assertEquals("ihg fed cba", transformer.apply("abc def ghi"));
  }

  @Test
  public void testApplyUpperCase() {
    assertEquals("FEDCBA", transformer.apply("ABCDEF"));
  }

  @Test
  public void testApplyLowerAndUpperCase() {
    assertEquals("DlROooW OlLEh", transformer.apply("HeLLo WoOoRLd"));
  }
}