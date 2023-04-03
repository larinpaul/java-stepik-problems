package ObjectOrientedProgramming.AbstractClassesAndInterfaces;

import java.util.function.DoubleUnaryOperator;

public class Integrate {

    // https://stepik.org/lesson/14513/step/7?unit=4147

    // Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале
    // по формуле левых прямоугольников.

    // Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator.
    // Его метод applyAsDouble() принимает значение аргумента
    // и возвращает значение функции в заданной точке.

    // Интервал интегрирования задается его конкретными точками a и b, причём a <= b.
    // Для получения достаточно точного результата используйте шаг сетки не больше Math.pow(10, -6)

    // Пример. Вызов
    // integrate(x -> 1, 0, 10)
    // должен возвращать значение 10.

    // P.S. Если задача слишком легкая, то дополнительно можете реализовать динамический выбор шага сетки
    // по следующему алгоритму:
    // 1. Вычислить приближенное значение интеграла функции при начальном значении шага сетки (например, 1).
    // 2. Вычислить приближенное значение интеграла функции при более мелком шаге сетки
    // (например, уменьшить шаг сетки в два раза).
    // 3. Если разность двух последовательных приближений интеграла функции достаточно мала,
    // то завершаем алгоритм и возвращаем текущее приближение в качестве результата.
    // Иначе возвращаемся к шагу 2.

    // * `f` is an object implementing the DoubleUnaryOperator interface,
    // which represents the mathematical function to be integrated.
    // Its `applyAsDouble` method takes a double value and returns the result of applying the function to that value
    // * `a`: a double value representing the lower bound of the integration interval
    // * `b`: a double value representing the upper bound of the integration interval.
    // The method integrates the function `f` over the interval `[a, b]` using the left rectangle method,
    // which approximates the area under the curve by the sum of the areas of left rectangles,
    // each with a width of `dx` (the step size) and a height equal to the function value
    // at the left endpoint of the rectangle
    public static double integrate(DoubleUnaryOperator f, double a, double b) { // DoubleUnaryOperator takes one double number as input and gives another double number as output.
        double step = 1e-6; // Sets the step size (шаг сетки) for the integration // 1e-6 = 0.000001
        // x is the currentPoint at which we are evaluating the function `f` during the integration process
        double x = a; // Sets the starting point for integration to be the left end point of the interval
        double integral = 0; // Initializes the integral to be zero

        while (x + step <= b) { // While the current point + step is less than the right end point of the interval
            integral += f.applyAsDouble(x) * step; // Adds the area of the rectangle
                                                   // formed by the function value at x times the step size
            x += step; // Increments the current point by the step size
        }

//        for (x = a; x + step <= b; x += step) { // Initialize x to a; continue while the current point + step is less than the right end point of the interval; increment x by the step size
//            integral += f.applyAsDouble(x) * step; // Adds the area of the rectangle formed by the function value at x times the step size
//        }

        if (x < b) { // If the current point is less that the right end point of the interval
            integral += f.applyAsDouble(x) * (b - x); // Adds the area of the rectangle formed by the function value
                                                      // at x times the remaining width of the interval
        }

        return integral;
    }


    // Интегрирование - нахождение интеграла. Это "объединение"
    // Найти интеграл, заданный функцией f(x) и на промежутке [a; b] -
    // это то же самое, что найти площадь фигуры S, буквально ограниченной отрезком от a до b и функцией f(x)

    // А вот тут начинается самое интерсное! Чтобы эту площадь вычислить, мы разбиваем отрезок и вообще фигуру
    // на кусочки - прямоугольники, находящиеся внутри фигуры. Длина кусока - это и будет наш шаг сетки (задаем сами)
    // Разбиение называется дифференцированием, кстати говоря.
    // Теперь находим значение функции в каждой точке каждого прямоугольника и, конечно же, находим сумму площадей всех
    // получившихся прямоугольников. Просто складывая, то есть объединяя, интегрируя их!
    // А это прекрасно выражается циклом. Естественно, чем меньше шаг сетки, тем больше точность!

    // Таким образом:
    // 1) Весь отрезок условно разбиваем на большое число маленьких отрезков double epsilon=1e-7, например.
    // 2) Далее для каждой точки отрезка [a,b] находим значение y=f(x) - это метод f.applyAsDouble(x).
    // Где x=a в начале вычисления.
    // К слову, y - это высота каждого отдельно прямоугольника.
    // 3) Сохраним полученное значение y в переменную sum+=y;
    // и увеличим текущую x на epsilon, чтобы перейти к следующему "прямоугольнику"
    // 4) Проделаем пункты 2-3-4 пока текущая точка x <= b
    // 5) Наконец, поскольку ширина прямоугольников постоянна, можно не считать площадь в цикле,
    // а выполнить в конце: умножим высоку на ширину return sum*epsilon;

}
