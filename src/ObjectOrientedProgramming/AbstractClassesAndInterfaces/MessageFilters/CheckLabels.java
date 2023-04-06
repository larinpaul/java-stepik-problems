package ObjectOrientedProgramming.AbstractClassesAndInterfaces.MessageFilters;

public class CheckLabels {

    // The method takes an array of TextAnalyzer objects and a String text as inputs,
    // and returns a Label object as output
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        // The method iterates over each TextAnalyzer object in the input array
        for (TextAnalyzer analyzer : analyzers) {
            // For each TextAnalyzer object, the method calls the processText method with the input text
            // If the result is not Label.OK, which indicates that the text has passed the analysis,
            // the method immediately returns the result
            if (analyzer.processText(text) != Label.OK) return analyzer.processText(text);
        }
        // If all analyzers pass the input text, the method returns Label.OK
        return Label.OK;
    }

}
