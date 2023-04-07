package HandlingErrorsExceptions.SquareRoot;

// Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
//
// Метод getCallerClassAndMethodName() должен возвращать имя класса и метода,
// откуда вызван метод, вызвавший данный утилитный метод.
// Или null (нулевую ссылку, а не строку "null"), если метод,
// вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.
//
// Это актуально, например, в библиотеках логирования,
// где для каждого сообщения в логе надо выводить класс и метод, откуда сообщение было залогировано.
//
// Пример:
// package org.stepic.java.example;
//
//public class Test {
//    public static void main(String[] args) {
//        System.out.println(getCallerClassAndMethodName());
//        anotherMethod();
//    }
//
//    private static void anotherMethod() {
//        System.out.println(getCallerClassAndMethodName());
//    }
//
//    public static String getCallerClassAndMethodName() {
//        // ...
//    }
//}
//    При запуске эта программа должна вывести:
//        null
//        org.stepic.java.example.Test#main
//        P.S. При тестировании этой программы в среде разработки вы можете получить другой результат:
//        вместо null в первой строчке будет напечатан какой-то посторонний класс и метод.
//        Это связано с тем, что среда разработки обычно запускает не ваш класс, а свой собственный,
//        который затем уже вызывает ваш. Чтобы этого избежать,
//        запускайте программу командой "java" в командной строке.
//
//        P.P.S. Эта задача в уроке про исключения не случайно :)

public class MethodCall {

    public static String getCallerClassAndMethodName() {
        // Get the current execution stack of the thred as an array of StackTraceElement objects
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            // At least 4 stack frames are needed for this method to work
            // If the length of is less than 4, return null
            return null;
        } else {
            // Get the fourth element of the stack trace array,
            // which represents the caller of the caller of this method
            StackTraceElement caller = stackTrace[3];
            // Return the class name and the method name of the caller, separated by a "#" symbol
            return caller.getClassName() + "#" + caller.getMethodName();
        }
    }


}
