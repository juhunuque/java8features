package java8features.methodreference;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

    static Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
    static Predicate<Student> p2 = RefactorMethodReferenceExample::greaterThanGradeLevel;

    public static boolean greaterThanGradeLevel(Student s) {
        return s.getGradeLevel() >=3;
    }

    public static void main(String[] args) {
        System.out.println(p2.test(StudentDataBase.studentSupplier.get()));

    }
}
