package BasicSyntax.PrimitiveTypes;

public class FlipBit {

    // https://stepik.org/lesson/12759/step/15?unit=3107

    // Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное.
    // Данная задача актуальная, например, при рбаоте с битовыми полями.

    // Договоримся, что биты нумеруются от младшего (индекс 1) к старшему (индекс 32).

    // Воспользуйтесь представленным шаблоном.
    // Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.

    // Sample Input:  0 1
    // Sample Output: 1

    // Sample Input:    // Sample Output:
    // 13  1             12
    // 13  2             15
    // 13  3             9
    // 13  4             5

    // Напишите программу. Тестируется через stdin → stdout

    /**
     * Flips one bit of the given <code>value</code>
     *
     * @param value    any number
     * @param bitIndex index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {

        // int is 32-bit by default, it has a minimum value of (2^31) and a maximum value of (-2^31)-1.
        // Math.pow(2, 31)             // Math.pow(-2, 31)-1
        // is it 0000 0000 0000 0000 0000 0000 0000 0000 in our case?
        // AH, I think I got it 2 to the power of 5 is 32...
        // And we usually count from 0 to 5, I guess... But here we could from 1 to 6

        // Bitwise operator works on bits and performs bit-by-bit operation.
        // Assume if a = 60 and b = 13; now in binary format they will be as follows:
        // a = 0011 1100 // 60
        // b = 0000 1101 // 13
        // -------------------

        // a&b = 0000 1100 // Binary AND operator copies a bit to the result if it exists in both operands
        // (a&b) gives 12 which is 0000 1100

        // a|b = 0011 1101 // Binary OR Operator copies a bit if it exists in either operand
        // (a|b) gives 61 which is 0011 1101

        // a^b = 0011 0001 // Binary XOR Operator copies the bit if it is set in one operand but not both
        // (a^b) gives 49 which is 0011 0001

        // ~a = 1100 0011 // Binary Ones Complement Operator is unary and has the effect of 'flipping' bits
        // (~a) gives -61 which is 1100 0011 in 2's complement form due to a signed binary number

        // << (left shift) // The left operands value is moved left by the number of bits specified by the right operand
        // a<<2 gives 240 which is 1111 0000

        // >> (right shift) // The left operands value is moved right by the number of bits specified by the right operand
        // a>>2 gives 15 which is 1111

        // >>> (zero fill right shift) // The left operands value
        // is moved right by the number of bits specified by the right operand and shifted values are filled up with zeros.
        // a>>>2 will give 15 which is 0000 1111

        // for example, let's take 386. In binary, it will be 0000 0001 1000 0010
        // let's imagine that we want to invert the 8th bit.
        // Since numeration starts with 0, bit will be 7
        // (is it in the task though? or is it also 8? But we have 32 bits)

        // Let's now raise the base of the system into the position of our bit.
        // Since the system is binary, and the bit is the 7th, we will raise 2 to the power of 7:
        // 2^7 = 128 = 0000 0000 1000 0000

        // Algotihm:
        // 1. Take number 1, as is binary, it is 00000001
        // 2. Moving it bitwise by bitIndex-1. Why -1? Because the creators of the task said:
        // "Договоримся, что биты нумеруются от младшего (индекс 1) к старшему (индекс 32)",
        // which means 1<<(bitIndex-1)
        // 3. Doing the XOR with value and the bitwise moved 1 (from step 2)
        // value ^ (1<<(bitIndex-1) // That is what we put into return.

        // Example:
        // We have 13. Change the 2nd bit to the opposite
        // Number 13 in binary is 1101. The 2nd bit is 0. So we change it to 1 and get 1111 (binary) = 15 (decimal)
        // What the program does:
        // 1 << 2-1, we get 0001 being turned into 0010
        // Doing step 3: 1101 ^ 0010 = 1111 (binary) = 15 (decimal)

        // Resulting code:
        return value ^ (1 << (bitIndex - 1));

        // 12:53 // Explanation by Bing Chat
        // Imagine you have a box with 32 switches inside. Each switch can be either on or off.
        // When a switch is on, we say it is 1, and when it is off, we say it is 0.
        // The box represents a number in binary, which means that each switch has a different value depending on its position.
        // For example, the switch on the rightmost side has a value of 1, the switch next to it has a value of 2,
        // the switch next to that has a value 4, and so on. You can add up the value of all the switches that
        // are on to get the number that the box represents.
        // For example, if the switches are 00000000000000000000000000001101, then the box represents 13,
        // because 1 + 0 + 4 + 8 = 13.

        // Now, your solution is method that takes two numbers as inputs: value and bitIndex. Value is another
        // box with 32 switches inside, and bitIndex is a number that tells you which switch you want to flip.
        // Flipping a switch means changing it from on to off from off to on. Your method returns a new box
        // with 32 switches inside, which is the result of flipping the switch at bitIndex in value.

        // To do this, your method uses two special tools: bitwise XOR and bitwise left shift. Bitwise XOR is a tool
        // that takes two boxes with 32 switches each and compares them switch by switch. If the switches at the
        // same position are different (one is on and one is off), then it turns on a new switch at that position.
        // If the switches at the same position are the same (both are on or both are off),
        // then it turns off a new switch at that position. For example, if you have two boxes like this:
        // 00000000000000000000000000101010
        // 00000000000000000000000001000100
        // And you use bitwise XOR on them, you will get a new box like this:
        // 00000000000000000000000001101110
        // Because only the switches at positions 2, 3, 5 and 7 are different.
        // Bitwise left shift is a tool that takes one box with 32 switches and a number n and moves all the
        // switches to the left by n positions. It also flips up the empty spaces on the right with zeros. For example,
        // if you have a box like this:
        // 00000000000000000000000000101010
        // And you use bitwise left shift by 3 on it, you will get a new box like this:
        // 00000000000000000000101010000
        // Because all the switches moved three positions to the left and three zeros were added to the right.
        // Now let's see how your method uses these tools to flip a switch in value.
        // YOUR METHOD DOES THESE STEPS:
        // * It subtracts 1 from bitIndex. This is because bitIndex starts from 1 (the rightmost switch) but we
        // want it to start from 0 (the leftmost switch).
        // * It uses bitwise left shift by (bitIndex - 1) on a box that has only one switch on at position 0.
        // This gives us a new box that has only one switch on at position (bitIndex - 1).
        // For example, if bitIndex is 3, then we get a new box like this:
        // 00000000000000000000000100
        // * It uses bitwise XOR between value and the new box we got form step 2.
        // This flips the switch at position (bitIndex - 1) in value and leaves all other switches unchanged.
        // For example, if value is this:
        // 01010101010101010101010101010101
        // And bitIndex is 3, then we get a new box like this:
        // 01010101010101010101010101010001
        // Because only the switch at position (bitIndex - 1) = (3 - 1) was flipped.
        // * It returns the new box we got form step 3 as the output.
        // So, your method flips one switch in value using bitwise XOR and bitwise left shift.
        // 13:10

    }

}
