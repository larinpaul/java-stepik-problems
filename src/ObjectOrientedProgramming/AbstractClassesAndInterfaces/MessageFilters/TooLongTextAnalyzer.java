package ObjectOrientedProgramming.AbstractClassesAndInterfaces.MessageFilters;

class TooLongTextAnalyzer implements TextAnalyzer {

    private int maxLength;

    // A class constructor which takes an integer maxLength as a parameter
    // and sets the instance variable maxLength to this value
    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    // Takes text as a parameter and checks if its length is greater than `maxLength`.
    // If it is greater, the method returns TOO_LONG, else returns OK
    @Override
    public Label processText(String text) {
        if (text.length() > maxLength)
            return Label.TOO_LONG;
        return Label.OK;
    }
}


