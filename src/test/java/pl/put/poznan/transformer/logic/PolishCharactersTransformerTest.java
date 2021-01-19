package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PolishCharactersTransformerTest {

  @Test
  public void testApply() {
    PolishCharactersMapper mapper = mock(PolishCharactersMapper.class);
    when(mapper.getPolishCharacters()).thenReturn(new HashSet<>() {{
      add("ą");
      add("ć");
    }});
    when(mapper.getLatinLetter(eq("ą"))).thenReturn("a");
    when(mapper.getLatinLetter(eq("ć"))).thenReturn("c");

    PolishCharactersTransformer transformer = new PolishCharactersTransformer(new InitialText(), mapper);

    String input = "aącć ććąą";
    String output = "aacc ccaa";
    assertEquals(output, transformer.transform(input));
  }

  @Test
  public void testApplyEmptySet() {
    PolishCharactersMapper mapper = mock(PolishCharactersMapper.class);
    when(mapper.getPolishCharacters()).thenReturn(new HashSet<>());

    PolishCharactersTransformer transformer = new PolishCharactersTransformer(new InitialText(), mapper);

    String input = "aącć ććąą";
    String output = "aącć ććąą";
    assertEquals(output, transformer.transform(input));
  }
}
