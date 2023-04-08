package GenericsCollectionsStreams.Collections.ReadFromSystemIn;

// https://stepik.org/lesson/12776/step/15?after_pass_reset=true&unit=3124

// Напишите программу, которая прочитает из System.in
// последовательность целых чисел, разделенных пробелами, затем
// удалит из них все числа, стоящие на четных позициях, и затем
// выведет получившуюся последовательность в обратном порядке
// в System.out

// Все числа влезают в int. Позиции чисел в последовательности
// немеруются с нуля.

// В этом задании надо написать программу целиком, включая import'ы,
// декларацию класса Main и метод main.

// Sample Input:
// 1 2 3 4 5 6 7
// Sample Output:
// 6 4 2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    // TODO Explain all
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < list.size(); i += 2) {
            result.add(list.get(i));
        }
        Collections.reverse(result);
        for (int num : result) {
            System.out.println(num + " ");
        }
    }




//    // TODO Explain all // DOESN'T WORK!
//    public static void main(String[] args) {
//        Scanner scanner;
//        scanner = new Scanner(System.in);
//        int n = 0;
//        ArrayList<Integer> arrayList = new ArrayList<>();
//
//        while (scanner.hasNextInt()) {
//            if (n % 2 != 0) {
//                arrayList.add(scanner.nextInt());
//            }
//            else scanner.next();
//            n++;
//        }
//
//        for (int i = arrayList.size() -1; i >= 0; i--) {
//            System.out.println(arrayList.get(i) + " ");
//        }
//    }


}
