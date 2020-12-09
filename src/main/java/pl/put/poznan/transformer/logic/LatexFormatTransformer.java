package pl.put.poznan.transformer.logic;

public class LatexFormatTransformer extends ActualTransformer{

    public LatexFormatTransformer(TextTransformer previous) {
        super(previous);
    }

    @Override
    protected String apply(String text) {
        return toLatexFormat(text);
    }

    static private String[] symbols = {"&", "\\$"};

    private String toLatexFormat(String text) {
        for(String symbol : symbols) {
            text = text.replaceAll(symbol, "\\\\" + symbol);
        }

        return text;
    }
}
