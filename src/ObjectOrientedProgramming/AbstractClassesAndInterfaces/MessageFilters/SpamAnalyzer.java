package ObjectOrientedProgramming.AbstractClassesAndInterfaces.MessageFilters;

class SpamAnalyzer extends KeywordAnalyzer {

    private String[] keywords;
    private Label label;

    // The method processText() from KeywordAnalyzer is inherited by SpamAnalyzer,
    // and it checks if any of the keywords are present in the input text.
    // If a keywords is found, the `label` instance variable is returned.
    // Otherwise, `Label.OK` is returned to indicate that the text is not spam.

    // This constructor takes an array of Strings as input, representing the keywords to be detected as spam.
    // The constructor initializes the `keywords` variable as a copy of the input array,
    // and sets the `label` variable to `Label.SPAM`
    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords.clone();
        label = Label.SPAM;
    }

    // The method processText() from KeywordAnalyzer is inherited by SpamAnalyzer,
    // and it checks if any of the keywords are present in the input text.
    // If a keywords is found, the `label` instance variable is returned.
    // Otherwise, `Label.OK` is returned to indicate that the text is not spam.

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }

}
