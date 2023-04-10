package GenericsCollectionsStreams.FunctionalInterfaces;

// https://stepik.org/lesson/12777/step/8?unit=3125

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class TernaryOperator {

    // Давайте научимся комбинировать функции в более сложные функции. Для примера построим следующую комбинацию.
    // Дан предикат condition и две функции ifTrue и ifFalse. Напиши метод ternaryOperator,
    // который из них построит новую функцию, возвращающую значение функции ifTrue, если предикат выполнен,
    // и значение ifFalse иначе.

    // Пример использования метода (можно было все свернуть в одну строчку,
    // но для наглядности все элементы вынесены в отдельные переменные):
//    Predicate<Object> condition = Objects::isNull;
//    Function<Object, Integer> ifTrue = obj -> 0;
//    Function<CharSequence, Integer> ifFalse = CharSequence::length;
//    Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

    // Результирующая функция будет для нулевых ссылок на String возвращать 0,
    // а для ненулевых ссылок возвращать длину строки.

    // В качестве дополнительного задания самостоятельно разберите,
    // почему у метода ternaryOperator такая сложная сигнатура

    //// Solution with explanation:
    // The solution can be implemented as follows:
    // 1. Declare the method `ternaryOperator` with type parameters `T` and `U`.
    // It takes a `Predicate` method `condition`, and two `Function`s named `ifTrue`
    // and `ifFalse` as parameters, and returns a new `Function`
    // that maps from type `T` to type `U`.
    // 2. Inside the `ternaryOperator` method, return a lambda expression that
    // takes a value of type `T` as input and returns the result of applying the `ifTrue` or `ifFasle` function
    // depending on the result of evaluating the `condition` predicate.
    // 3. Use the ternary operator `? :` to check if the `condition` is true or false,
    // and apply the corresponding function accordingly.

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse
    ) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }
    // The signature of `ternaryOperator` method is a bit complex because it uses wildcard
    // type parameters (`? super T` and `? extends U`) to allow for greater flexibility in the
    // types of the `condition`, `ifTrue`, and `ifFalse` parameters. This is necessary because
    // the `Predicate` and `Function` interfaces have different type parameters.

    // Here's an example usage of the `ternaryOperator` method:
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        // Test the function
        System.out.println(safeStringLength.apply(null)); // Output: 0
        System.out.println(safeStringLength.apply("hello")); // Output: 5
    }

    Optional;

    // Maria Zorkaltseva
    // Можно протестировать свою функцию чем-то подобным:
    public static void test() {
        Predicate<Integer> condition = n -> (n % 2) == 0;
        Function<Integer, String> ifTrue = n -> "Number is even";
        Function<Integer, String> ifFalse = n -> "Number is odd";

        Function<Integer, String> isEven = ternaryOperator(condition, ifTrue, ifFalse);

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(isEven.apply(sc.nextInt()));
        }
        catch (Exception e) {

        }

    }


}
