package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateRemoverTest {
  private DuplicateRemover transformer;

  @BeforeEach
  public void setUp() {
    transformer = new DuplicateRemover(new InitialText());
  }

  @Test
  public void testApplyTwoDuplicates() {
    assertEquals("hello world", transformer.apply("hello world world"));
  }

  @Test
  public void testApplyThreeDuplicates() {
    assertEquals("hello world", transformer.apply("hello hello hello world"));
  }

  @Test
  public void testApplyLotsOfDuplicates() {
    assertEquals("hello world hello a",
            transformer.apply("hello hello hello hello world world hello hello a a a a a a a a a"));
  }

  @Test
  public void testApplyZeroDuplicates() {
    assertEquals("hello world", transformer.apply("hello world"));
  }
}