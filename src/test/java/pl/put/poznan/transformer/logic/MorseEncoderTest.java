package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MorseEncoderTest {

  /**
   * Test if in output morse words are separated with 3 spaces
   * and characters by single space
   */
  @Test
  void testApplySeparation() {
    MorseMapper mapper = mock(MorseMapper.class);
    when(mapper.getMorse('a')).thenReturn(".");

    MorseEncoder encoder = new MorseEncoder(new InitialText(), mapper);

    String input = "aaa a aa";
    String output = ". . .   .   . .";
    assertEquals(output, encoder.transform(input));
  }

  /**
   * Tests if encoder ignores characters for which there's no mapping
   */
  @Test
  void testApplyIgnoreUndefined() {
    MorseMapper mapper = mock(MorseMapper.class);
    when(mapper.getMorse(anyChar())).thenReturn(null);
    when(mapper.getMorse(eq('a'))).thenReturn(".");

    MorseEncoder encoder = new MorseEncoder(new InitialText(), mapper);

    String input = "aaxa zac a";
    String output = ". . .   .";
    assertEquals(output, encoder.transform(input));
  }
}
