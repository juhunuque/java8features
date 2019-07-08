package java8features.streams;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.Optional;

public class StreamsFindAnyFirstExample {

    public static Optional<Student> findAnyStudent() {
        return StudentDataBase.getAllStudents().stream()
                .filter(s -> s.getGpa() >= 3.9)
                .findAny();
    }

    public static Optional<Student> findFirstStudent() {
        return StudentDataBase.getAllStudents().stream()
                .filter(s -> s.getGpa() >= 3.9)
                .findFirst();
    }
    public static void main(String[] args) {

        Optional<Student> studentOptional = findAnyStudent();
        if(studentOptional.isPresent()) {
            System.out.println("Found the student : " + studentOptional.get());
        } else {
            System.out.println("No value returned");
        }

        Optional<Student> studentFindFirstOptional = findFirstStudent();
        if(studentFindFirstOptional.isPresent()) {
            System.out.println("Found the first student : " + studentFindFirstOptional.get());
        } else {
            System.out.println("No value returned");
        }

    }
}
