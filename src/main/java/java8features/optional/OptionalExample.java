package java8features.optional;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {

    public static String getStudentName() {
        Student student = StudentDataBase.studentSupplier.get();

        if(student != null) {
            return student.getName();
        }
        return null;
    }

    public static Optional<String> getStudentNameOptional() {
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        if(student.isPresent()) {
            return student.map(Student::getName);
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        String name = getStudentName();

        if(name != null) {
            System.out.println("Length of student name : " + name.length());
        } else {
            System.out.println("Name not found");
        }

        Optional<String> stringOptional = getStudentNameOptional();

        if(stringOptional.isPresent()) {
            System.out.println("Length of student name : " + stringOptional.get().length());
        } else {
            System.out.println("Name not found");
        }
    }
}
