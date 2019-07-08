package java8features.streams;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilterExample {

    public static List<Student> filterStudents() {
        return StudentDataBase.getAllStudents().stream()
                .filter(s -> s.getGender().equals("female"))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        System.out.println(filterStudents());

    }
}
