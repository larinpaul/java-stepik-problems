package ObjectOrientedProgramming.AbstractClassesAndInterfaces;

public class AsciiCharSequenceTest {

    //// 2023/04/06

    // Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
    // (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char,
    // AsciiCharSequence будет занимать в два раза меньше памяти.

    // Класс AsciiCharSequence должен:
    // * реализовывать интерфейс java.lang.CharSequence;
    // * иметь конструктор, принимающий массив байт;
    // * определять методы length(), charAt(), subSequence и toString()

    // Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence
    //                                                                              (JavaDoc или исходники).

    // В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры,
    // поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы ещё не проходили исключения

    // P.S. В Java 9 ожидается подобная оптимизация в самом классе String: http://openjdk.java.net/jeps/254

    public static void main(String[] args) {

        byte[] example = {72, 101, 108, 108, 111, 33}; // H e l l o !
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Sequence: " + answer.toString()); // Hello!
        System.out.println("Sequence size: " + answer.length()); // 6
        System.out.println("Symbol at index 0: " + answer.charAt(0)); // H
        System.out.println("Symbol at index 1: " + answer.charAt(1)); // e
        System.out.println("Subsequence from index 1including to index 5excluding" + answer.subSequence(1, 5)); // ello
        // Проверка на нарушение инкапсуляции
        System.out.println(answer.toString()); // Hello!
        example[0] = 74; // J
        System.out.println(answer.toString()); // Hello!
    }




}
