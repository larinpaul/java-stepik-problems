package ObjectOrientedProgramming.AbstractClassesAndInterfaces.MessageFilters;



public class MessageFiltersTest {

    // Пришло время попробовать реализовать иерархию классов определенного вида и решить конкретную задачу.

    // Представим, что Вы делаете систему фильтрации комментариев на каком-то веб-портале, будь то новости,
    // видео-хостинг, а может даже системы онлайн-обучения :)

    // Вы хотите фильтровать комментарии по разным критериям, уметь легко добавлять новые фильтры
    // и модифицировать старые.

    // Допустим, мы будем фильтровать спам, комментарии с негативным содержанием и слишком длинные комментарии.
    // Спам будем фильтровать по наличию указанных ключевых слов в тексте.
    // Негативное содержание будем определять по наличию одного из трех смайликов - :( =( :|
    // Cлишком длинные комментарии будем определять исходя из данного числа - максимальной длины комментария.

    // Вы решили абстрагировать фильтр в виде следующего интерфейса:
    //  interface TextAnalyzer {
    //     Label processText(String text);
    //  }
    // Label - тип-перечисление, который содержит метки, которыми будем помечать текст
    //  enum Label {
    //      SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    //  }

    // Дальше, вам необходимо реализовать три класса, которые реализуют данный интерфейс:
    // SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer.
    // 1. SpamAnalyzer должен конструироваться от массива строк с ключевыми словами. Объект этого класса должен
    // сохранять в своем состоянии этот массив строк в приватном поле keywords.
    // 2. NegativeTextAnalyzer должен конструироваться конструктором по-умолчанию.
    // 3. TooLongAnalyzer должен конструироваться от int'a с максимальной допустимой длиной комментария.
    // Объект этого класса должен сохранять в своем состоянии это число в приватном поле maxLength.

    // Наверняка вы уже заметили, что SpamAnalyzer и NegativeTextAnalyzer во многом похожи - они оба проверяют текст на
    // наличие каких-либо ключевых слов (в случае спама мы получаем их из контруктора, в случае негативного текста мы
    // заранее знаем набор грустных смайликов) и в случае нахождения одного из ключевых слов возвращают Label (SPAM и
    // NEGATIVE_TEXT соответственно), а если ничего не нашлось - возращают ОК.
    // Давайте эту логику абстрагируем в абстрактый класс KeywordAnalyzer следующим образом:
    // 1. Выделим два абстрактных метода getKeywords и getLabel, один из которых будет возвращать набор ключевых слов,
    // а второй метку, которой необходимо пометить положительные срабатывания. Нам незачем показывать эти методы
    // потребителям классов, поэтому оставим доступ к ним только для наследников.
    // 2. Реализуем processText таким образом, чтобы он зависел только от getKeywords и getLabel.
    // 3. Сделаем SpamAnalyzer и NegativeTextAnalyzer наследниками KeywordAnalyzer и реализуем абстрактные методы.

    // Последний штрих - написать метод checkLabels, который будет возвращать метру для комментария по набору
    // анализаторов текста. checkLabels должен возвращать первую не-ОК метку в порядке данного набора анализаторов,
    // и ОК, если все анализаторы вернули ОК.

    // Используйте, пожалуйста, модификатор доступа по-умолчанию для всех классов.
    // В итоге реализуйте классы KeyWordAnalyzer, SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer и метод checkLabels.
    // TextAnalyzer и Label уже подключены, лишние импорты вам не потребуются.

    public static void main(String[] args) {

        // Инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // Тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good."; // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;"; // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;"; // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad...."; // SPAM
        tests[5] = "This comment is an example of spam, maybeeeeeeeeeeeeeeeee!"; // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam."; // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very negative =(, very ........................."; // SPAM or NEGATIVE_TEXT or TOO_LONG

        TextAnalyzer[][] textAnalyzers = {
                textAnalyzers1,
                textAnalyzers2,
                textAnalyzers3,
                textAnalyzers4,
                textAnalyzers5,
                textAnalyzers6
        };

        CheckLabels testObject = new CheckLabels();
        int numberOfAnalyzer; // Номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // Номер теста, который соответствует индексу тестоых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.println("Test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.println(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }
}
// Поместите тесты в класс для теста, как для тестирования checkLabels() создается экземпляр класса,
// так как checkLabels() по заданию не-static. В моем случае это класс MessageFiltersTest (или Main)

