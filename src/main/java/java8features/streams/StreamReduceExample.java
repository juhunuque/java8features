package java8features.streams;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    public static int performMultiplication(List<Integer> integerList) {
        return integerList.stream()
                .reduce(1, (a, b) -> a*b);
    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList) {
        return integerList.stream()
                .reduce((a, b) -> a*b);
    }

    public static Optional<Student> getHighestGpaStudent() {
        return StudentDataBase.getAllStudents().stream()
                .reduce((s1, s2) -> {
                    if(s1.getGpa() > s2.getGpa()) {
                        return s1;
                    } else {
                        return s2;
                    }
                });
    }

    public static Optional<Student> getHighestGpaStudent2() {
        return StudentDataBase.getAllStudents().stream()
                .reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
    }


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5,7);

        System.out.println("The multiplication result is : " + performMultiplication(integers));
        System.out.println("The multiplication without identity result is : " + performMultiplicationWithoutIdentity(integers).get());

        Optional<Student> studentOptional = getHighestGpaStudent2();

        if(studentOptional.isPresent()) {
            System.out.println("The highest GPA is : " + studentOptional.get());
        }

    }
}
