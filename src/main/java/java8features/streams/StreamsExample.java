package java8features.streams;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {

        Predicate<Student> studentPredicate = s -> s.getGradeLevel() >= 3;
        Predicate<Student> studentGpaPredicate = s -> s.getGpa() >= 3.9;

        Map<String, List<String>> studentsMap = StudentDataBase
                .getAllStudents().stream()
                .filter(studentPredicate)
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println(studentsMap);

        Map<String, List<String>> studentsDebugMap = StudentDataBase
                .getAllStudents().stream()
                .peek(System.out::println)
                .filter(studentPredicate)
                .peek(s -> {
                    System.out.println("Student 1st filter :" + s);
                })
                .filter(studentGpaPredicate)
                .peek(s -> {
                    System.out.println("Student 2st filter :" + s);
                })
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
    }
}
