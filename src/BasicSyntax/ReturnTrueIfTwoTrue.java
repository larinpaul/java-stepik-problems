package BasicSyntax;

public class ReturnTrueIfTwoTrue {

    //// 2023/03/29 // 12:53 //

    // Реализуйте метод, возвращающий true, если среди четырех его аргументов ровно два истинны (любые).
    // Во всех остальных случаях метод должен возвращать false.

    // Вам надо только проанализировать переданные в метод booleanExpression значения (a, b, c, d) и вернуть результат.
    // Попробуйте составить формулу с использованием булевых операторов. Если не получится, вернитесь после
    // просмотра видео про условные операторы и циклы.

    // При записи сложных выражений рекомендуется использовав скобки, чтобы не запутаться в порядке применения операторов

    // В качестве примера уже указано заведомо некорректное решение задачи. Исправьте его.

    // Совет тем, у кого не проходит какой-то из тестов. В данной задаче возможно всего 16 комбинаций значений входных
    // параметров. Их можно выписать на бумажку, посчитать для них правильные ответы и сравнить с тем, что выдает ваше
    // решение. Попробуйте самостоятельно проделать это, найти ошибку и исправить решение.

    // Sample Input 1: false false false false // Sample Output 1: false
    // Sample Input 2: true true true true // Sample Output 2: false
    // Sample Input 3: false false true true // Sample Output 3: true


    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {

        // & true is both a AND b is true
        // | true if either a OR b is true
        // ^ true if a is true AND b is false OR if b is false AND b is true
        // ! true if !a is false


//        return (
//                true & true & false & false ||
//                true & false & true & false ||
//                true & false & false & true ||
//                false & true & true & false ||
//                false & true & false & true ||
//                false & false & true & true
//        );

        //// Logical operators solution
//        return (
//                (a && b && !c && !d) || // 1100
//                (!a && !b && c && d) || // 0011
//                (a && !b && !c && d) || // 1001
//                (!a && b && c && !d) || // 0110
//                (!a && b && !c && d) || // 0101
//                (a && !b && c && !d) // 1010
//                );


//        //// Counter solution (WORKS)
        int counter = 0;
        if(a == true) counter++;
        if(b == true) counter++;
        if(c == true) counter++;
        if(d == true) counter++;
//        if (counter == 2) {
//            return true;
//        } else {
//            return false;
//        }
        return counter==2;

//        //// Ternary operator Solution (WORKS)
//        // condition ? valueIfTrue : valueIfFalse
//        return (a ? 1 : 0) + (b ? 1 : 0) + (c ? 1 : 0) + (d ? 1 : 0) == 2;

        // 14:33
        // It took me 1 hour and 40 minutes to solve it

    }

}
