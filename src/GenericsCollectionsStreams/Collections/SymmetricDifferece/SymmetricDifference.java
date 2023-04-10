package GenericsCollectionsStreams.Collections.SymmetricDifferece;

// https://stepik.org/lesson/12776/step/14?unit=3124

// Реализуйте метод, вычисляющий симметрическую разность двух множеств.

// Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

// Пример
// Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {

    /**
     * The method first creates a new `HashSet` to store symmetric difference of `set1` and `set2`.
     * It then iterates through each element in `set1`, checking if it's not present in `set2`
     * and adding it to the symmetric difference set if that's the case. Next, it iterates
     * through each element in `set2`, checking if it's not present in `set1` and adding it
     * to the symmetric difference set if that's the case.
     * Finally, the method returns the symmetric difference set. Note that this implementation
     * creates a new `HashSet`, so the original `set1` and `set2` re not modified.
     * @param set1
     * @param set2
     * @return
     * @param <T>
     */
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        // Create a new HashSet to store the symmetric difference of set1 and set2
        Set<T> symmetricDiff = new HashSet<>();

        // Add all elements in set1 that are not in set2 to symmetricDiff
        for (T element : set1) {
            if (!set2.contains(element)) {
                symmetricDiff.add(element);
            }
        }

        // Add all elements in set2 that are not in set1 to symmetricDiff
        for (T element : set2) {
            if (!set1.contains(element)) {
                symmetricDiff.add(element);
            }
        }

        // Return the symmetric difference set
        return symmetricDiff;
    }


    // Test
    public static void main(String[] args) {

        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);

        // Shorter test:
//        Set<Integer> num1 = new HashSet(Arrays.asList(3, 7, 9));

    }

}
