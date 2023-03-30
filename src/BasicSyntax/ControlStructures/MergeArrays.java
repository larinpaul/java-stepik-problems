//package BasicSyntax.ControlStructures;
//
//import static java.lang.System.arraycopy;
//import static java.lang.System.in;
//
//public class MergeArrays {
//
//    // https://stepik.org/lesson/12762/step/9?unit=3110
//
//    // Реализуйте метод, сливающий два отсортированных по неубыванию массива числе в один отсортированный
//    // в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.
//
//    // Пердполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум исходным
//    // массивам и сразу форматировать отсортированный результирующий массив. Так, чтобы сортировка полученного массива
//    // при помощи Arrays.sort() уже не требовалась. К сожалению, автоматически это не проверить,
//    // так что это остается на вашей совести.
//
//    // Пример
//    // Если на вход подаются массивы {0, 2, 2} и {1, 3}, то на выходе должен получиться массив {0, 1, 2, 2, 3}
//
//    /**
//     * Merges two given sorted arrays into one
//     *
//     * @param a1 first sorted array
//     * @param a2 second sorted array
//     * @return new array containing all elements from a1 and a2, sorted
//     */
//
//    // Not my solution, gotta do it my way!
//    public static int[] mergeArrays(int[] a1, int[] a2) {
//
//
//        int[] resultingArray = new int[a1.length + a2.length];
//        int index1 = 0;
//        int index2 = 0;
//        while (index1 < a1.length || index2 < a2.length) {
//            resultingArray[index1 + index2] = ( // condition ? value_if_true : value_if_false
//                    // index1 is within the bounds of a1 and either index2 is out of bounds of 2
//                    // or the element at index1 in a1 is smaller than the element at index2 in a2.
//                    index1 < a1.length && (index2 == a2.length || a1[index1] < a2[index2])
//                            ? a1[index1++] : a2[index2++]);
//        }
//        return resultingArray;
//    }
//
//
//}
