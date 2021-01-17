package pl.put.poznan.transformer.rest;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.put.poznan.transformer.logic.InitialText;
import pl.put.poznan.transformer.logic.TextTransformerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TextTransformerControllerTest {

  @Test
  void testGet() {
    TextTransformerFactory factory = mock(TextTransformerFactory.class);
    when(factory.createTextTransformer(any(String[].class))).thenReturn(new InitialText());

    TextTransformerController controller = new TextTransformerController(factory);

    String input = "random text";
    String[] transforms = { "randomTransform" };
    ResponseEntity<TextTransformerResult> response = controller.get(input, transforms);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(input, response.getBody().getResult());
  }
}
