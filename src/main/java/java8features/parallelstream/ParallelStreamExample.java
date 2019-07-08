package java8features.parallelstream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static long checkPerformanceResult(Supplier<Integer>supplier , int numberOfTimes) {

        long startTime = System.currentTimeMillis();
        for(int i=0; i<numberOfTimes; i++) {
            supplier.get();
        }
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public static int sumSequentialSteam() {
        return IntStream.rangeClosed(1, 1000000)
                .sum();

    }

    public static int sumParallelSteam() {
        return IntStream.rangeClosed(1, 1000000)
                .parallel()
                .sum();

    }

    public static void main(String[] args) {
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("sumSequentialSteam : " + checkPerformanceResult(ParallelStreamExample::sumSequentialSteam, 20));
        System.out.println("sumParallelSteam : " + checkPerformanceResult(ParallelStreamExample::sumParallelSteam, 20));
    }
}
