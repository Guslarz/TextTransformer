package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Rot13TransformerTest {

  @Test
  public void testApplyRot13() {
    Rot13Mapper mapper = mock(Rot13Mapper.class);
    when(mapper.getCodedLetter(anyChar())).thenReturn('x');

    Rot13Transformer transformer = new Rot13Transformer(new InitialText(), mapper);

    String input = "abc de f";
    String output = "xxx xx x";
    assertEquals(output, transformer.transform(input));
  }

  @Test
  public void testApplyWithUndefined() {
    Rot13Mapper mapper = mock(Rot13Mapper.class);
    when(mapper.getCodedLetter(anyChar())).thenAnswer(i -> i.getArguments()[0]);
    when(mapper.getCodedLetter(eq('a'))).thenReturn('n');

    Rot13Transformer transformer = new Rot13Transformer(new InitialText(), mapper);

    String input = "aąać";
    String output = "nąnć";
    assertEquals(output, transformer.transform(input));
  }
}
