package java8features.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodsExample {


    public static void main(String[] args) {
        /**
         * Prior Java 8
         */
        List<String> stringList = Arrays.asList("Adam", "Jenny", "Alex", "Dan", "Mike", "Eric");
        Collections.sort(stringList);
        System.out.println("Sorted list using Collections.sort() : " + stringList);

        /**
         * Java 8
         */

        List<String> stringList2 = Arrays.asList("Adam", "Jenny", "Alex", "Dan", "Mike", "Eric");
        stringList2.sort(Comparator.naturalOrder());
        stringList2.sort(Comparator.reverseOrder());
        System.out.println("Sorted list using List.sort() : " + stringList2);


    }
}
