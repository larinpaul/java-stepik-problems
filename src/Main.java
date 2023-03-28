import BasicSyntax.AssertEqualNumbers;
import BasicSyntax.Gregorian;

import static BasicSyntax.AssertEqualNumbers.doubleExpression;
import static BasicSyntax.Gregorian.leapYearCount;
import static BasicSyntax.ValidPalindrome.*;

public class Main {
    public static void main(String[] args) {

        // Palindrome
        String myString0 = "Madam, I'm Adam!";
        String myString1 = "This is not a palindrome!";
        String myString2 = "!Palindrome121emordnilaP!";
        System.out.println("Checking: "+myString0+" Is it a valid Palindrome? -> "+isPalindrome(myString0));
        System.out.println("Checking: "+myString1+" Is it a valid Palindrome? -> "+isPalindrome(myString1));
        System.out.println("Checking: "+myString2+" Is it a valid Palindrome? -> "+isPalindrome(myString2));

        // Gregorian
        // int leapYearCount = leapYearCount(400);
        // System.out.println("Leap year count is: " + leapYearCount);
//        System.out.println("Leap year count is: " + leapYearCount(400));

        // AssertEqualNumbers
        double a = 0.1;
        double b = 0.2;
        double c = 0.3;
        // boolean areEqual = AssertEqualNumbers.doubleExpression(a, b, c);
        // System.out.println(a+"+"+b+"="+c+", this is "+areEqual);
//         System.out.println(a+"+"+b+"="+c+", this is "+doubleExpression(a, b, c));
        int a2 = 1;
        int b2 = 2;
        int c2 = 3;
        // boolean areEqual2 = AssertEqualNumbers.doubleExpression(a2, b2, c2);
        // System.out.println(a2+"+"+b2+"="+c2+", this is "+areEqual2);
//         System.out.println(a2+"+"+b2+"="+c2+", this is "+doubleExpression(a2, b2, c2));
    }
}