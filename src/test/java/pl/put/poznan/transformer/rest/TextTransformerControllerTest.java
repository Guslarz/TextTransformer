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

  @Test
  void testPostV2() {
    TextTransformerFactory factory = mock(TextTransformerFactory.class);
    when(factory.createTextTransformer(any(String[].class))).thenReturn(new InitialText());

    TextTransformerRequestBody requestBody = mock(TextTransformerRequestBody.class);
    when(requestBody.getText()).thenReturn("random text");
    when(requestBody.getTransforms()).thenReturn(new String[] { "randomTransform" });

    TextTransformerController controller = new TextTransformerController(factory);

    ResponseEntity<TextTransformerResult> response = controller.postV2(requestBody);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals("random text", response.getBody().getResult());
  }
}
