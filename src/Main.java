
import java.lang.reflect.Array;
import java.util.Arrays;

import static BasicSyntax.ControlStructures.Factorial.alphabet;
import static BasicSyntax.TypeConversion.IsPowerOfTwo.isPowerOfTwo;

import static BasicSyntax.PrimitiveTypes.FlipBit.flipBit;
import static BasicSyntax.TypeConversion.IsPowerOfTwo.isPowerOfTwoVerbose;
import static BasicSyntax.TypeConversion.UnicodeDistance.charExpression;

public class Main {
    public static void main(String[] args) {

        //// 2023/03/30



//        //// Merge Arrays // NOT FINISHED
//        int[] array1 = {1, 2, 3};
//        int[] array2 = {3, 4, 5};
//        int[] mergedArray = mergeArrays(array1, array2);
//        System.out.println(Arrays.toString(mergedArray));


//        //// IsPowerOfTwo
//        System.out.println(isPowerOfTwo(2)); // true
//        System.out.println(isPowerOfTwo(-2)); // true
//        System.out.println(isPowerOfTwo(0)); // false
//        System.out.println(isPowerOfTwo(32)); // true
//        System.out.println(isPowerOfTwo(332)); // false


//        //// Return a letter that is `a` blocks away after "\" in the UNICODE table
//        int aDistance1 = 32; // Expect |
//        System.out.println("The distance of " + aDistance1 + " after \\ gives us " + charExpression(aDistance1));
//        int aDistance2 = 29; // Expect y
//        System.out.println("The distance of " + aDistance2 + " after \\ gives us " + charExpression(aDistance2));

        alphabet();

//        //// Factorial of BigInteger
//        System.out.println(factorial(1));
//        System.out.println(factorial(2));
//        System.out.println(factorial(5));
//        System.out.println(factorial(10));
//        System.out.println(factorial(50));
//        System.out.println(factorial(100));
//        System.out.println(factorial(10000));

        //// 2023/03/29

//        //// flipBit
//        // Test case 1: value = 13, bitIndex = 3, expected output = 9
//        int value1 = 13; // (0b1101)
//        int bitIndex1 = 3;
//        int output1 = flipBit(value1, bitIndex1);
//        System.out.println("Test case 1: value = " + value1 + ", bitIndex = " + bitIndex1 + ", output = " + output1);
//        // Test case 2: value = 42, bitIndex = 6, expected output = 10
//        int value2 = 42; // (0b101010)
//        int bitIndex2 = 6;
//        int output2 = flipBit(value2, bitIndex2);
//        System.out.println("Test vase 2: value = " + value2 + ", bitIndex = " + bitIndex2 + ", output = " + output2);


//        //// Return true of two true
//        boolean result1 = booleanExpression(true, false, false, false); // 1000
//        System.out.println("false1" + result1);
//
//        boolean result2 = booleanExpression(true, true, false, false); // 1100
//        System.out.println("true2" + result2); // true
//
//        boolean result3 = booleanExpression(true, true, true, false); // 1110
//        System.out.println("false3" + result3);
//
//        boolean result4 = booleanExpression(true, true, true, true); // 1111
//        System.out.println("false4" + result4);
//
//        boolean result5 = booleanExpression(false, false, false, true); // 0001
//        System.out.println("false5" + result5);
//
//        boolean result6 = booleanExpression(false, false, true, true); // 0011
//        System.out.println("true6" + result6); // true
//
//        boolean result7 = booleanExpression(false, true, true, true); // 0111
//        System.out.println("false7" + result7);
//
//        boolean result8 = booleanExpression(true, false, false, true); // 1001
//        System.out.println("true8" + result8); // true
//
//        boolean result9 = booleanExpression(false, true, true, false); // 0110
//        System.out.println("true9" + result9); // true
//
//        boolean result10 = booleanExpression(true, false, true, false); // 1010
//        System.out.println("true10" + result10); // true
//
//        boolean result11 = booleanExpression(false, true, false, true); // 0101
//        System.out.println("true11" + result11); // true
//
//        boolean result12 = booleanExpression(false, true, false, false); // 0100
//        System.out.println("false12" + result12);
//
//        boolean result13 = booleanExpression(false, false, true, false); // 0010
//        System.out.println("false13" + result13);
//
//        boolean result14 = booleanExpression(false, false, false, false); // 0000
//        System.out.println("false14" + result14);
//
//        boolean result15 = booleanExpression(true, false, true, true); // 1011
//        System.out.println("false15" + result15);
//
//        boolean result16 = booleanExpression(true, true, false, true); // 1101
//        System.out.println("false16" + result16);

        //// 2023/03/28

//        // Valid Palindrome
//        String myString0 = "Madam, I'm Adam!";
//        String myString1 = "This is not a palindrome!";
//        String myString2 = "!Palindrome121emordnilaP!";
//        System.out.println("Checking: "+myString0+" Is it a valid Palindrome? -> "+isPalindrome(myString0));
//        System.out.println("Checking: "+myString1+" Is it a valid Palindrome? -> "+isPalindrome(myString1));
//        System.out.println("Checking: "+myString2+" Is it a valid Palindrome? -> "+isPalindrome(myString2));
//        System.out.println("Checking: "+myString2+" Is it a valid Palindrome? -> "+isPalindromeWithEquals(myString2));
//
//        // Gregorian
////         int leapYearCount = leapYearCount(400);
////         System.out.println("Leap year count is: " + leapYearCount);
////        System.out.println("Leap year count is: " + leapYearCount(400));
//
//        // AssertEqualNumbers
//        double a = 0.1;
//        double b = 0.2;
//        double c = 0.3;
//        // boolean areEqual = AssertEqualNumbers.doubleExpression(a, b, c);
//        // System.out.println(a+"+"+b+"="+c+", this is "+areEqual);
////         System.out.println(a+"+"+b+"="+c+", this is "+doubleExpression(a, b, c));
//        int a2 = 1;
//        int b2 = 2;
//        int c2 = 3;
//        // boolean areEqual2 = AssertEqualNumbers.doubleExpression(a2, b2, c2);
//        // System.out.println(a2+"+"+b2+"="+c2+", this is "+areEqual2);
////         System.out.println(a2+"+"+b2+"="+c2+", this is "+doubleExpression(a2, b2, c2));
    }
}