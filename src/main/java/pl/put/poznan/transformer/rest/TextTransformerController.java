package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.TextTransformerFactory;

import java.util.Arrays;


@RestController
@RequestMapping("/api")
public class TextTransformerController {

  private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

  @GetMapping(produces = "application/json")
  @ResponseBody
  public ResponseEntity<TextTransformerResult> get(
      @RequestParam String text,
      @RequestParam(defaultValue = "upper") String[] transforms) {

    logger.debug("New GET request");

    return createResponse(text, transforms);
  }

  @PostMapping(
      consumes = "application/x-www-form-urlencoded",
      produces = "application/json")
  public ResponseEntity<TextTransformerResult> postV1(
      @RequestParam String text,
      @RequestParam(defaultValue = "upper") String[] transforms) {

    logger.debug("New POST request");

    return createResponse(text, transforms);
  }

  @PostMapping(
      consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<TextTransformerResult> postV2(
      @RequestBody TextTransformerRequestBody body) {

    logger.debug("New POST request");

    return createResponse(body.getText(), body.getTransforms());
  }

  private ResponseEntity<TextTransformerResult> createResponse(String text, String[] transforms) {

    logger.debug(text);
    logger.debug(Arrays.toString(transforms));

    TextTransformer transformer = TextTransformerFactory.createTextTransformer(transforms);
    String result = transformer.transform(text);

    return new TextTransformerResult(result, HttpStatus.OK).toResponseEntity();
  }
}
