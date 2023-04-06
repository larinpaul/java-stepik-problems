package SkypeCall06Friday;

public class StringSbCompare {

    public static void main(String[] args) {

        System.out.println("___String is Immutable___");

        String str1 = "a";
        System.out.println("Original String: " + str1);
        String str1HashCodeBefore = String.valueOf(str1.hashCode());
        System.out.println("str1HashCodeBefore " + str1HashCodeBefore); // 97
        str1 = str1.concat("g");
        System.out.println("A new String object is created and put into str1 = " + str1);
        String str1HashCodeAfter = String.valueOf(str1.hashCode());
        System.out.println("str1HashCodeAfter " + str1HashCodeAfter); // 3110

        System.out.println("___StringBuilder is Mutable___");
        StringBuilder sb1 = new StringBuilder("a");
        System.out.println("Original StringBuilder: " + sb1);
        String sb1HashCodeBefore = String.valueOf(sb1.hashCode());
        System.out.println("sb1HashCodeBefore " + sb1HashCodeBefore); // 1072591677
        sb1 = sb1.append("g");
        System.out.println("The same StringBuilder object is changed = " + sb1);
        String sb1HashCodeAfter = String.valueOf(sb1.hashCode());
        System.out.println("sb1HashCodeAfter " + sb1HashCodeAfter); // 1072591677
//
//
//
//        System.out.println("String is immutable:");
//
//        String str1 = "a";
//        System.out.println(str1);
//        String str2 = str1.concat("b");
//        System.out.println(str1); // a
//        System.out.println(str1 == str1); // true
//        System.out.println(str1 == str2); // false
//        System.out.println(str1.hashCode() == str2.hashCode()); // false
//        String str1HashCodeBefore = String.valueOf(str1.hashCode());
//        System.out.println("Proof that String is immutable:");
//        System.out.println("str1HashCodeBefore " + str1HashCodeBefore); // 97
//        str1 = str1.concat("g");
//        String str1HashCodeAfter = String.valueOf(str1.hashCode());
//        System.out.println("str1HashCodeAfter " + str1HashCodeAfter); // 3110
//
//        System.out.println("StringBuilder is mutable:");
//
//        StringBuilder sb1 = new StringBuilder("a");
//        System.out.println(sb1); // a
//        StringBuilder sb2 = sb1.append("b");
//        System.out.println(sb1); // ab
//        System.out.println(sb1 == sb1); // true
//        System.out.println(sb1 == sb2); // true
//        System.out.println(sb1.hashCode() == sb2.hashCode()); // true
//        System.out.println("Proof that StringBuilder is immutable:");
//        String sb1HashCodeBefore = String.valueOf(sb1.hashCode());
//        System.out.println("sb1HashCodeBefore " + sb1HashCodeBefore); // 1072591677
//        sb1 = sb1.append("g");
//        String sb1HashCodeAfter = String.valueOf(sb1.hashCode());
//        System.out.println("sb1HashCodeAfter " + sb1HashCodeAfter); // 1072591677



    }




}
