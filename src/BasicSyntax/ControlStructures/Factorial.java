package BasicSyntax.ControlStructures;

import java.math.BigInteger;

public class Factorial {

    // https://stepik.org/lesson/12762/step/8?unit=3110

    // Реализуйте метод, вычисляющий факториал заданного натурального числа.

    // Факториал N вычисляется как 1 * 2 * ... * N.

    // Поскольку это очень быстро растущая функция, то даже для небольших N вместимости типов int и long
    // очень скоро не хватит. Поэтому будем использовать BigInteger.

    // Sample Input 1:  1
    // Sample Output 1: 1

    // Sample Input 2:  3
    // Sample Output 2: 6

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static int factorialLoopInt(int value) {
        int factorialResult = 1;
        for (int i = 2; i <= value; i++) { // Starting with 2 because 1 is redundant
            factorialResult = factorialResult*i;
        }
        return factorialResult;
    }

    public static void alphabet() {

//        int iny = iny+1;

        // До каких пор нам нужно интерироваться.

        for (char i = 'a'; i == 'z'; i++) {


            System.out.println(i);

        }

    }

    public static BigInteger factorial(int value) {
        BigInteger factorialResult = BigInteger.ONE;
        for (int i = 2; i <= value; i++) {
            factorialResult = factorialResult.multiply(BigInteger.valueOf(i));
        }
        return factorialResult;
    }

    // There can also be a recursive solution

}
