package java8features.optional;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.Optional;

public class OptionalMapFlatMapExample {

    public static void optionalFilter() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        studentOptional
                .filter(s -> s.getGpa() >= 4.0)
                .ifPresent(s -> System.out.println(s));
    }

    public static void optionalMap() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        if(studentOptional.isPresent()) {
            Optional<String> name = studentOptional
                    .filter(s -> s.getGpa() >= 3.5)
                    .map(Student::getName);
            System.out.println("Name : " + name);
        }
    }

    public static void optionalFlatMap() {

        Optional<Student> studentOptional =
                Optional.ofNullable(StudentDataBase.studentSupplier.get());

    }

    public static void main(String[] args) {
        optionalFilter();
        optionalMap();
    }
}
