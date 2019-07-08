package java8features.streams;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorExample {

    public static List<Student> sortStudentsByName() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGpaDesc() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        System.out.println("Students sorted by Name : ");
        sortStudentsByName().forEach(System.out::println);

        System.out.println("Students sorted by Gpa : ");
        sortStudentsByGpaDesc().forEach(System.out::println);


    }
}
