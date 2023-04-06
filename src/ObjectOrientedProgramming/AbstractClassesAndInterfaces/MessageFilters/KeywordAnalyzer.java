package ObjectOrientedProgramming.AbstractClassesAndInterfaces.MessageFilters;


abstract class KeywordAnalyzer implements TextAnalyzer {

    // Should return an array of `String` representing the keywords that the analyzer will look for in the text
    abstract protected String[] getKeywords();

    // Should return the `Label` that will be returned by processText if any of the keywords are found in the text
    abstract protected Label getLabel();

    // Iterates over the array of keywords returned by `getKeywords` and checks
    // if the keyword is present in the input `text`.
    // If any keyword is found, the `Label` returned by `getLabel` is returned.
    // If none of the keywords are found, `Label.OK` is returned
    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword))
                return getLabel();
        }
        return Label.OK;
    }

}
