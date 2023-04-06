package ObjectOrientedProgramming.AbstractClassesAndInterfaces.MessageFilters;

class NegativeTextAnalyzer extends KeywordAnalyzer {

    private String[] keywords;
    private Label label;

    // The constructor initializes the `keywords` and `label` fields
    // with the corresponding values for negative text analysis
    public NegativeTextAnalyzer() {
        this.keywords = new String[3];
        this.keywords[0] = ":(";
        this.keywords[1] = "=(";
        this.keywords[2] = ":|";
        label = Label.NEGATIVE_TEXT;
    }

    // Returns the array of negative text keywords that are initiated by the constructor
    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    // Returns the `NEGATIVE_TEXT` label, which indicates that the analyzed text contains negative content
    @Override
    protected Label getLabel() {
        return label;
    }
}
