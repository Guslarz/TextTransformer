package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MorseDecoderTest {

  /**
   * Checks whether morse input is properly split into separate words and characters
   */
  @Test
  public void testApplySplitMorse() {
    MorseMapper mapper = mock(MorseMapper.class);
    when(mapper.getAscii(anyString())).thenReturn('x');

    MorseDecoder decoder = new MorseDecoder(new InitialText(), mapper);

    String input = ".--- . ... -   -.. --- -... .-. --.. .";
    String output = "xxxx xxxxxx";
    assertEquals(output, decoder.transform(input));
  }

  /**
   * Tests if decoder ignores codes for which there's no mapping
   */
  @Test
  void testApplyIgnoreUndefined() {
    MorseMapper mapper = mock(MorseMapper.class);
    when(mapper.getAscii(anyString())).thenReturn(null);
    when(mapper.getAscii(eq("."))).thenReturn('x');

    MorseDecoder decoder = new MorseDecoder(new InitialText(), mapper);

    String input = ". -   .-- . . -.";
    String output = "x xx";
    assertEquals(output, decoder.transform(input));
  }
}
