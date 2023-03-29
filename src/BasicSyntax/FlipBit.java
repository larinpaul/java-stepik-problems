//package BasicSyntax;
//
//public class FlipBit {
//
//    // Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное.
//    // Данная задача актуальная, например, при рбаоте с битовыми полями.
//
//    // Договоримся, что биты нумеруются от младшего (индекс 1) к старшему (индекс 32).
//
//    // Воспользуйтесь представленным шаблоном.
//    // Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
//
//    // Sample Input:  0 1
//    // Sample Output: 1
//
//    // Sample Input:    // Sample Output:
//    // 13  1             12
//    // 13  2             15
//    // 13  3             9
//    // 13  4             5
//
//    // Напишите программу. Тестируется через stdin → stdout
//    /**
//     * Flips one bit of the given <code>value</code>
//     *
//     * @param value     any number
//     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
//     * @return new value with one bit flipped
//     */
//    public static int flipBit(int value, int bitIndex) {
//
//        // int is 32-bit by default, it has a minimum value of (2^31) and a maximum value of (-2^31)-1.
//                                                    // Math.pow(2, 31)             // Math.pow(-2, 31)-1
//        // is it 0000 0000 0000 0000 0000 0000 0000 0000 in our case?
//        // AH, I think I got it 2 to the power of 5 is 32...
//        // And we usually count from 0 to 5, I guess... But here we could from 1 to 6
//
//        // Bitwise operator works on bits and performs bit-by-bit operation.
//        // Assume if a = 60 and b = 13; now in binary format they will be as follows:
//        // a = 0011 1100 // 60
//        // b = 0000 1101 // 13
//        // -------------------
//
//        // a&b = 0000 1100 // Binary AND operator copies a bit to the result if it exists in both operands
//        // (a&b) gives 12 which is 0000 1100
//
//        // a|b = 0011 1101 // Binary OR Operator copies a bit if it exists in either operand
//        // (a|b) gives 61 which is 0011 1101
//
//        // a^b = 0011 0001 // Binary XOR Operator copies the bit if it is set in one operand but not both
//        // (a^b) gives 49 which is 0011 0001
//
//        // ~a = 1100 0011 // Binary Ones Complement Operator is unary and has the effect of 'flipping' bits
//        // (~a) gives -61 which is 1100 0011 in 2's complement form due to a signed binary number
//
//        // << (left shift) // The left operands value is moved left by the number of bits specified by the right operand
//        // a<<2 gives 240 which is 1111 0000
//
//        // >> (right shift) // The left operands value is moved right by the number of bits specified by the right operand
//        // a>>2 gives 15 which is 1111
//
//        // >>> (zero fill right shift) // The left operands value
//        // is moved right by the number of bits specified by the right operand and shifted values are filled up with zeros.
//        // a>>>2 will give 15 which is 0000 1111
//
//        // for example, let's take 386. In binary, it will be 0000 0001 1000 0010
//        // let's imagine that we want to invert the 8th bit.
//        // Since numeration starts with 0, bit will be 7
//        // (is it in the task though? or is it also 8? But we have 32 bits)
//
//        // Let's now raise the base of the system into the position of our bit.
//        // Since the system is binary, and the bit is the 7th, we will raise 2 to the power of 7:
//        // 2^7 = 128 = 0000 0000 1000 0000
//
//        return value ^ (1<<bitIndex); // Stanislav Klevstov // если сдвинуть на 1 бит число 8, то получим 10 - верно.
//                                      // Если 0 на 1 бит, то 2. Но в примере выше 1... Ошибка. Нужно исправить
//        return 1 << (bitIndex - 1) ^ value; // Ayub Kosimov
//        return(value ^ ((int)Math.pow(2, (bitIndex-1)))); // Дмитрий Сергеев
//
//
//        // Solution by Bing:
//        // You can use the bitwise not operator ~ to flip all the bits in an integer:
//        int nOriginal;
//        int nFlipped = ~nOriginal;
//
//        // However, this will flip all 32 bits in the integer, not just the ones that are used to represent the number.
//        // If you want to slip only a specific bit at a given position, you can use the bitwise XOR operator ^
//        // with a mask that has a 1 at that position nad 0s elsewhere.
//        int n;
//        int k; // k is the position of the bit to flip, from 1 to 32
//        int mask = 1 << (k - 1); // create a mask with a 1 at position k
//        return n ^ mask; // XOR n with the mask to flip the bit
//
//
//
////        return ; // put your implementation here
//    }
//
//}
