package BasicSyntax.TypeConversion;

public class IsPowerOfTwo {

    // https://stepik.org/lesson/12760/step/9?unit=3108

    // Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.

    // Решать можно разными способами:
    // * Воспользовавшись одним удобным статическим методом из класса java.lang.Integer;
    // * Применив пару трюков из двоичной арифметики;
    // * Написав решение "в лоб" с циклом и условными операторами (можете вернуться к этой задаче после просмотра соответсвующих уроков)

    // Sample Input 1:  0
    // Sample Output 1: false
    // Sample Input 2:  1
    // Sample Output 2: true
    // Sample Input 3:  -2
    // Sample Output 3: true

    /**
     * CHecks if given <code>value</code> is a power of two.
     *
     * @param value
     * @return <code>true</code> when <code>vlaue</code> is a power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwoVerbose(int value) {

        // The good thing about numbers that are powers of two,
        // is that in any of its n power, we can see 1 only at (n+1)th bit. All the other bits are zeroes. For example:
        // 16 is 10000 in binary.
        // 32 is 1000000 in binary.
        // We need to check that a number has only one bit.

        // Let's assume that k is 2 to the power of n.
        // The number k has 1 only at the (n+1)th bit.
        // So k-1 has 1 in all the bits from 1 to n.
        // If we use bitwise OR, we should get 0. For example:
        // 32 & 31 == 0 // true
        // 100000
        // &
        // 011111
        // =
        // 000000
        // http://www.pvsm.ru/java/39711

        // Decimal // Power of 2 // Binary
        // 1      // 2**0    // 1
        // 2      // 2**1    // 10
        // 4      // 2**2    // 100
        // 8      // 2**3    // 1000
        // 16     // 2**4    // 10000
        // 32     // 2**5    // 100000
        // 64     // 2**6    // 1000000
        // 128    // 2**7    // 10000000
        // 256    // 2**8    // 100000000
        // 512    // 2**9    // 1000000000
        // 1024   // 2**10   // 10000000000
        // bitCount(int i) - returns an integer of the number of 1s in the binary format of the argument number

        value = Math.abs(value);
        int counter = Integer.bitCount(value);
        System.out.println(counter);
        return counter == 1;
    }

    public static boolean isPowerOfTwo(int value) {
        return Integer.bitCount(Math.abs(value)) == 1;
    }

    public static boolean isPowerOfTwoBitwise(int value) {
//        boolean isTrue = (value & (value-1) == 0;
//        (32 & 32) == 0 // true

//        (value & (value - 1)) == 0;
        return true;
    }

    public static int bitCount(int i) {
        i -= i >>> 1 & 1431655765;
        i = (i & 858993459) + (i >>> 2 & 858993459);
        i = i + (i >>> 4) & 252645135;
        i += i >>> 8;
        i += i >>> 16;
        return i & 63;
    }

}
