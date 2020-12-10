package pl.put.poznan.transformer.rest;

public class TextTransformerRequestBody {

  private String text_;
  private String[] transforms_ = { "upper" };

  public String getText() {
    return text_;
  }

  public void setText(String text) {
    text_ = text;
  }

  public String[] getTransforms() {
    return transforms_;
  }

  public void setTransforms(String[] transforms) {
    transforms_ = transforms;
  }
}
