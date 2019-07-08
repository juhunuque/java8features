package java8features.optional;

import java.util.Optional;

public class OptionalPresentExample {

    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.ofNullable("hello Optional");
        System.out.println(stringOptional.isPresent());

        stringOptional.ifPresent(System.out::println);
    }
}
