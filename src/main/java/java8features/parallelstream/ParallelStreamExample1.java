package java8features.parallelstream;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample1 {

    public static List<String> sequentialPrintStudentActivities() {
        long starTime = System.currentTimeMillis();
        List<String> stringList = StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(Collection::stream) // Stream<String>
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();

        System.out.println("sequentialPrintStudentActivities time: " + (endTime - starTime));

        return stringList;
    }

    public static List<String> parallelPrintStudentActivities() {
        long starTime = System.currentTimeMillis();
        List<String> stringList = StudentDataBase.getAllStudents().stream()
                .parallel()// Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(Collection::stream) // Stream<String>
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();

        System.out.println("parallelPrintStudentActivities time: " + (endTime - starTime));

        return stringList;

    }

    public static void main(String[] args) {
        sequentialPrintStudentActivities();
        parallelPrintStudentActivities();

    }
}
