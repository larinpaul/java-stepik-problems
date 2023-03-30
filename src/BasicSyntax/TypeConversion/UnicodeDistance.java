package BasicSyntax.TypeConversion;

public class UnicodeDistance {

    // https://stepik.org/lesson/12760/step/3?unit=3108

    // Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш)
    // на расстоянии а.

    // В качестве примера написано заведомо неправильное выражение. Исправьте его.
    // Sample Input 1:  32
    // Sample Output 1: |
    // Sample Input 2:  29
    // Sample Output 2: y

    // Unicode "\" Is Reverse Solidus // Unicode number: U+005C // HTML-code: &#92;
    // 0050 to the left C to the top
    // In the Java unicode chart: // https://www.ssec.wisc.edu/~tomw/java/unicode.html#x0000
    // 0x005C // 92 // REVERSE SOLIDUS // \
    // int ch1 = '\\'; // 92
    // int ch2 = '2'; // 119

    public static char charExpression(int a) {
        return (char) (a + '\\');
    }

    public static char charExpressionVerbose(int a) {
//        int ch1 = '\''; // 39
//        System.out.println(ch1); // 39
//        int ch2 = 'w'; // 119
//        System.out.println(ch2); // 119
//        int ch3 = '\\'; // 92
//        System.out.println(ch3); // 92
//        int ch4 = '/';  // 47
//        System.out.println(ch4); // 47

        char myChar = (char) (a + 92);
        System.out.println("My result should be: " + myChar);


        int keyCharNumber = '\\';
        char resultingCharFromInt = (char) (a + keyCharNumber);
        System.out.println("My result should be: " + resultingCharFromInt);

        char resultingChar = (char) (a + '\\');
        System.out.println("My result is going to be: " + myChar);
        return resultingChar;
    }


}
