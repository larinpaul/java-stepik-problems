package IoAndFileSystem.CharStreams;

// https://stepik.org/lesson/12784/step/13?unit=3131

// Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте
// вещественных чисел с точностью до шестого знака после запятой. Числом считается последовательность символов,
// отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.

// На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main - таково ограничение
// проверяющей системы), метод main, прописать все import'ы.

// Sample Input1:
// 1 2 3
// Sample Output 1:
// 6.000000
// Sample Input 2:
// a1 b2 c3
// Sample Output 2:
// 0.000000
// Sample Input 3:
// -1e3
// 18.111 11bbb
// Sample Output 3:
// -981.889000

import java.util.Scanner;
import java.util.Locale;

public class MainReadingFromSystemIn {

    public static void main(String[] args) {
        // Создаем новый Scanner для чтения данных из System.in с использованием английской локали
        Scanner scanner = new Scanner(System.in);
        double sum = 0;

        // Читаем каждое слово из входного потока, пока есть следующее
        while (scanner.hasNext()) {
            try {
                // Пытаемся прочитать следующее слово как вещественное число и добавить его к сумме
                sum += scanner.nextDouble();
            } catch (Exception e) {
                // Если слово не является вещественным числом, то игнорируем его и читаем следующее
                scanner.next();
            }
        }

        // Выводим сумму с точностью до 6 знаков после запятой
        System.out.printf("%.6f", sum);
    }

}
