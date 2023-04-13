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
import java.util.Collections;
import java.util.Scanner;

public class Main {

    // TODO Explain all
    public static void main(String[] args) {
        // Create a new Scanner object to read input from System.in
        Scanner scanner = new Scanner(System.in);
        // Create a new ArrayList to hold the integers read from input
        ArrayList<Integer> list = new ArrayList<>();
        // Read integers from input and add them to the list
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        // Create a new ArrayList to hold the integers at odd positions
        ArrayList<Integer> result = new ArrayList<>();
        // Iterate over the list and add integers at odd positions to the result list
        for (int i = 1; i < list.size(); i += 2) {
            result.add(list.get(i));
        }
        // Reverse the order of the integers in the result list
        Collections.reverse(result);
        // Iterate over the integers in the result list and print them to System.out
        for (int num : result) {
            System.out.println(num + " ");
        }
    }

}
