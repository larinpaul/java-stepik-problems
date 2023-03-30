package BasicSyntax.PrimitiveTypes;

public class Gregorian {

    // Started at 11:40
    // https://stepik.org/lesson/12759/step/8?auth=login&unit=3107

    // В Григорианском календаре год является високосным в двух случаях:
    // либо он кратен 4, но при этом не кратен 100, либо кратен 400

    // Реализуйте метод, вычисляющий количество високосных лет с начала нашей эры (первого года) до заданного года
    // включительно. На самом деле Григорианский календарь был введен значительно позже, но здесь для упрощения мы
    // распространяем его действие на всю нашу эру.

    // Ввод-вывод обеспечивает проверяющая система. Вам надо только проанализировать переданное в метод значение и
    // вернуть результат. В программу всегда подается положительный номер года. Предполагается решение без циклов.
    // Вам надо придумать и записать несложную формулу, использующую только арифметические операторы.

    // В качестве примера написано заведомо неправильно выражение. Исправьте его
    // (Don't know, seems correct...).
    // Sample Input 1:
    // 1
    // Sample Output 1:
    // 0 // 0
    // Sample Input 2:
    // 4 //
    // Sample Output 2:
    // 1 // 1
    // Sample Input 3:
    // 100 //
    // Sample Output 3:
    // 24 // 24

    public static int leapYearCountVerbose(int year) {
        int generalYear = year;
        int leapYear = (generalYear/4)-(generalYear/100)+(generalYear/400);
        year = leapYear;
        return year;
    }

    public static int leapYearCount(int year) {
        year = (year/4)-(year/100)+(year/400);
        return year;
    }

    // Finished at 12:07
    // It took me 27 minutes to solve it

}
