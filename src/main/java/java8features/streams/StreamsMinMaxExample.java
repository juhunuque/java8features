package java8features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static int findMaxValue(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, (x, y) -> x > y ? x : y);
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce((x, y) -> x > y ? x : y);
    }

    public static int findMinValue(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, (x, y) -> x < y ? x : y);
    }

    public static Optional<Integer> findMinValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce((x, y) -> x < y ? x : y);
    }
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6,7,8,9,10);

        System.out.println("The max number is : " + findMaxValue(integerList));

        Optional<Integer> minValueOptional = findMinValueOptional(integerList);
        if (minValueOptional.isPresent()) {
            System.out.println("The min number is : " + findMinValueOptional(integerList).get());
        } else {
            System.out.println("No min value resulted");
        }
    }
}
