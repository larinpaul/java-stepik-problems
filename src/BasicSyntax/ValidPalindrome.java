package BasicSyntax;

public class ValidPalindrome {

    // Started solving at 13:00

//    Реализуйте метод, проверяющий, является ли заданная строка палиндромом.
//    Палиндромом называется строка, которая читается одинаково слева направо и справа налево (в том числе пустая).
//    При определении "палиндромности" строки должны учитываться только буквы и цифры.
//    А пробелы, знаки препинания, а также регистр символов должны игнорироваться.
//    Гарантируется, что в метод попадают только строки, состоящие из символов ASCII
//    (цифры, латинские буквы, знаки препинания).
//    Т.е. русских, китайских и прочих экзотических символов в строке не будет.
//
//    Воспользуйтесь предоставленным шаблоном.
//    Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
//
//    Подсказки (не читайте, если хотите решить сами):
//
//    для удаления из строки всех символов, не являющихся буквами и цифрами,
//    можно воспользоваться регулярным выражением "[^a-zA-Z0-9]";
//    найдите в классе String метод, выполняющий замену по регулярному выражению;
//    для перестановки символов строки в обратном порядке можно воспользоваться методом reverse(),
//    который находится в классе StringBuilder;
//    в классе String есть методы для преобразования всей строки в верхний и нижний регистр.
    // Sample Input:
    // Madam, I'm Adam!
    // Sample Output:
    // true

    // The regular expression `[^A-Za-z1-9]+` matches any character that is not an uppercase
    // letter (A-Z), lowercase letter (a-z), or digit (0-9). The `^` symbol inside the square brackets
    // negates the character set, meaning it matches any character that is not in the set.
    // The `+` quantifier means to match one or more occurences of the preceding pattern.
    // The `replaceAll` method replaces all occurrences of the matched pattern with an empty
    // string, effectively removing all non-alphanumeric characters from the input string.

    public static boolean isPalindromeVerbose(String text) {
        String preparedString = text.replaceAll("[^a-zA-Z0-9]","");
        StringBuilder sbText = new StringBuilder(preparedString);
        String reversedStringFromSbText = sbText.reverse().toString();
        boolean isValidPalindrome = preparedString.equalsIgnoreCase(reversedStringFromSbText);
        return isValidPalindrome;
    }

    public static boolean isPalindrome(String text) {
        StringBuilder sbText = new StringBuilder(text.replaceAll("[^a-zA-Z0-9]",""));
        return sbText.toString().equalsIgnoreCase(sbText.reverse().toString());
    }



    // Finished solving at 14:23
    // It took me 1 hour 23 minutes to solve this.

    // Would be cool if you could write a solution with a loop too...

}
