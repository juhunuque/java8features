package java8features.streams;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

    public static List<String> printStudentActivities() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(Collection::stream) // Stream<String>
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static long getStudentActivitiesCount() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(Collection::stream) // Stream<String>
                .distinct() // Stream<String> -> with distinct function performed
                .count();
    }

    public static void main(String[] args) {
        System.out.println(printStudentActivities());
        System.out.println(getStudentActivitiesCount());

    }
}
