package java8features.streams_terminal;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPartitioningByExample {

    public static Map<Boolean, List<Student>> partitionBy_1() {
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;

        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpaPredicate));
    }

    public static Map<Boolean, Set<Student>> partitionBy_2() {
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;

        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpaPredicate,
                        Collectors.toSet()));
    }

    public static void main(String[] args) {
        System.out.println("partitionBy_1 : " + partitionBy_1());
        System.out.println("partitionBy_2 : " + partitionBy_2());

    }
}
