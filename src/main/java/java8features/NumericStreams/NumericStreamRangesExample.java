package java8features.NumericStreams;

import java.util.stream.IntStream;

public class NumericStreamRangesExample {

    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 50);
        System.out.println(intStream.count());

        IntStream.range(1, 50).forEach(value -> System.out.println(value + ", "));

        IntStream intStreamClosed = IntStream.rangeClosed(1, 50);
        intStreamClosed.forEach(value -> System.out.println(value + ", "));

        IntStream.range(1, 50).asDoubleStream().forEach(v -> System.out.println(v + ", "));
    }
}
