package GenericsCollectionsStreams.StreamAPI.PseudoRandomStream;

import java.util.stream.IntStream;

public class PseudoRandomStream {

    // Here's an explanation of what the method does:
    // * It creates an `IntStream` using the `IntStream.iterate` method.
    // * The `seed` value is used as the first element of the stream.
    // * The second argument of the `iterate` method is a lambda expression that
    // takes the previous element of the stream (`n`) and applies a function to it to
    // generate the next element of the stream.
    // * The function used in the lambda expression is `((n * n) / 10) % 1000`,
    // which takes the square of the previous element, divides it by 10, and then takes
    // the remainder of diving the result by 1000.
    // * This function generates a new integer value based on the previous value,
    // which is then added to the stream.

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }

    // In other words, the `pseudoRandomStream` method generates a sequence of
    // integers using a simple mathematical formula based on the previous value,
    // starting with the `seed` value, and returns an `IntStream` containing this
    // sequence. This sequence is not truly random, but rather a pseudo-random
    // sequence that is determined by the starting `seed` value and the mathematical
    // formula used to generate the sequence

}
