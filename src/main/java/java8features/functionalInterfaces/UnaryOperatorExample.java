package java8features.functionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    static UnaryOperator<String> stringUnaryOperator = s -> s.concat("Default");

    public static void main(String[] args) {
        System.out.println(stringUnaryOperator.apply("Java8"));

    }
}
