package BasicSyntax.PrimitiveTypes;

public class AssertEqualNumbers {

    // Started solving at 12:25

    // Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
    // Допустимая погрешность - 0.0001 (1Е-4)
    // Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.
    // В качестве примера написано заведомо неправильное выражение. Исправьте его.
    // Sample Input:
    // 0.1 0.2 0.3
    // Sample Output:
    // true
    // Напишите программу. Тестируется через stdin -> stdout // I don't see why we need this, do we need to use Scanner?

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) <= 0.0001;
    }

    // Finished at 12:42
    // It took me 17 minutes to solve it

    // But wouldn't the difference
    // -0.00000000000000004 still be smaller than 0.00000000000000004,
    // and they would both be smaller than 0.0001?
    // can I use return (a + b - c) <= 0.0001; ?
    // is Math.abs necessary?
    // Probably it is necessary... But I need to think about it again later.

}
