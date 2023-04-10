package GenericsCollectionsStreams.StreamAPI.PseudoRandomStream;

import java.util.stream.IntStream;

public class PseudoRandomStream {

    // TODO Understand and explain
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }



}
