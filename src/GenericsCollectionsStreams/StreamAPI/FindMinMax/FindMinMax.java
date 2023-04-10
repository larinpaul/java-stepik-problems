package GenericsCollectionsStreams.StreamAPI.FindMinMax;

// https://stepik.org/lesson/12781/step/12?unit=3128

// Напишите метод, находящий в стриме минимальный и максимальный элементы
// в соответствии с порядком, заданным Comparatar'ом.

//// Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
//minMaxConsumer.accept(min, max);
//// Если стрим не содержит элементов, то вызовите
//minMaxConsumer.accept(null, null);

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        // Step 1: Collect the stream into a list
        List<? extends T> list = stream.collect(Collectors.toList());

        // Step 2: Check if the list is empty
        if (list.isEmpty()) {
            // If the list is empty, pass null for min and max
            minMaxConsumer.accept(null, null);
        } else {
            // Step 2.1: If the list is not empty, sort it using the given Comparator
            Collections.sort(list, order);
            // Step 2.2: Get the minimum and maximum elements from the sorted list
            T min = list.get(0);
            T max = list.get(list.size() - 1);
            // Pass the min and max elements to the consumer
            minMaxConsumer.accept(min, max);
        }
    }



}
