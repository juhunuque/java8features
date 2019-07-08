package java8features.NumericStreams;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateExample {

    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 50).sum();
        System.out.println("Sum is : " + 50);

        OptionalInt max = IntStream.rangeClosed(1, 50).max();
        System.out.println("Max is : " + max.getAsInt());

        OptionalLong min = LongStream.rangeClosed(1, 50).min();
        System.out.println("Min is : " + min.getAsLong());

        OptionalDouble average = IntStream.rangeClosed(1, 50).average();
        System.out.println("Average is : " + average.getAsDouble());
    }
}
