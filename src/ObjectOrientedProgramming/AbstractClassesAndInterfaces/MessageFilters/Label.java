package ObjectOrientedProgramming.AbstractClassesAndInterfaces.MessageFilters;

enum Label {

    // A fixed set of constants. Each item is basically a String
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK

    // Under the hood, when you declare an enum value like `SPAM`,
    // it is equivalent to new Label("SPAM")`
    // Therefore, each enum value is an instance of the enum class,
    // with a name field that holds the String representation of the value

}
