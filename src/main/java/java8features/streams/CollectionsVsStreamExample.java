package java8features.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsVsStreamExample {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Adam");
        names.add("Jim");
        names.add("Jenny");

        names.remove(0);

        System.out.println(names);

        names.stream();

        Stream<String> nameStream = names.stream();

        nameStream.forEach(System.out::println);


    }
}
