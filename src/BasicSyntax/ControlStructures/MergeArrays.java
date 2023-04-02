package BasicSyntax.ControlStructures;

import static java.lang.System.arraycopy;
import static java.lang.System.in;

public class MergeArrays {

    // https://stepik.org/lesson/12762/step/9?unit=3110

    // Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный
    // в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.

    // Пердполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум исходным
    // массивам и сразу форматировать отсортированный результирующий массив. Так, чтобы сортировка полученного массива
    // при помощи Arrays.sort() уже не требовалась. К сожалению, автоматически это не проверить,
    // так что это остается на вашей совести.

    // Пример
    // Если на вход подаются массивы {0, 2, 2} и {1, 3}, то на выходе должен получиться массив {0, 1, 2, 2, 3}

    // Слияние двух отсортированных массивов. "Структуры данных и алгоритмы Java. Роберт Лафоре"
    // Центральное место в алогоритме сортировки слиянием занимает слияние двух предварительно
    // отсортированных массивов. В результате слияния двух отсортированных массивов А и В
    // создается тертий массив С, который содержит все элементы А и В, также расположенные в порядке сортировки.
    // Сначала мы рассмотрим сам процесс слияния, а потом разберемся, как он используется при сортировке.

    // Представьте, что у вас имеются два предварительно отсортированных массива
    // (причём необязательно одинакового размера)
    // Допустим, массив А содержит 4 элемента, а массив В - 6. Массивы объединяются посредством слияния в массив С,
    // изначально состоящий из 10 пустых ячеек
    // A [23, 47, 81, 95]
    //
    // B [7, 14, 39, 55, 62, 74]
    //
    // C [7, 14, 23, 39, 47, 55, 62, 74, 81, 95]
    //
    // На рисунке числа в кружках обозначают порядок перемещения элементов из А и В в С.
    // Ниже перечислены сравнения, необходимые дял определения копируемых элементов.
    // Нумерация операций в табилце соответствует нумерации на рисунке.
    // После каждого сравнения меньший элемент копируется в А.
    // Так как после выпонления шага 8 массив В не содержит элементов, дополнительные сранвнения не нужны;
    // Все оставшиеся элементы просто копируются из А в С.
    // Шаг // Сравнение // Копирование
    // 1        23 и 7      7 из В в С
    // 2        23 и 14     14 из А в С
    // 3        23 и 39     13 из А в С
    // 4        39 и 47     39 из В в С
    // 5        55 и 47     47 из А в С
    // 6       55 и 81     55 из В в С
    // 7        62 и 81     62 из И в С
    // 8        74 и 81     74 из В в С
    // 9                    81 из А в С
    // 10                   95 из А в С

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */

    public static int[] mergeArrays(int[] a1, int[] a2) {

        if (a1 == null && a2 == null) {
            return null;
        } else if (a1 == null) {
            return a2;
        } else if (a2 == null) {
            return a1;
        }

        int[] arrayC = new int[a1.length + a2.length];

        int indexA = 0;
        int indexB = 0;

        for (int indexC = 0; indexC < arrayC.length; indexC++) {
            if (indexA < a1.length && indexB < a2.length) {
                if (a1[indexA] < a2[indexB]) {
                    arrayC[indexC] = a1[indexA];
                    indexA++;
                } else {
                    arrayC[indexC] = a2[indexB];
                    indexB++;
                }
            } else if (indexA < a1.length) {
                arrayC[indexC] = a1[indexA];
                indexA++;
            } else {
                arrayC[indexC] = a2[indexB];
                indexB++;
            }
        }

        return arrayC;
    }


    public static int[] mergeArraysWhileLoops(int[] a1, int[] a2) {

        if (a1 == null && a2 == null) {
            return null;
        } else if (a1 == null) {
            return a2;
        } else if (a2 == null){
            return a1;
        }

        // {1, 2, 3}
        // {3, 4, 5}
        int[] arrayC = new int[a1.length + a2.length]; // {1, 2, 3, 3, 4, 5}

        int indexA = 0; // 3
        int indexB = 0; // 3

        while (indexA < a1.length && indexB < a2.length) {

            // Compare the elements of the input array and copy the smaller one to the resulting array
            if (a1[indexA] < a2[indexB]) { // 1 ,
                arrayC[indexA + indexB] = a1[indexA];
                indexA++; // Move to the next element of the first array
            }
            else {
                arrayC[indexA + indexB] = a2[indexB];
                indexB++; // Move to the next element of the second array
            }
        }

        // Copy the remaining elements of the first array if possible
        while (indexA < a1.length) {
            arrayC[indexA + indexB] = a1[indexA];
            indexA++;
        }

        // Copy the remaining elements of the second array if possible
        while (indexB < a2.length) {
            arrayC[indexA + indexB] = a2[indexB];
            indexB++;
        }

        return arrayC;
    }

}
