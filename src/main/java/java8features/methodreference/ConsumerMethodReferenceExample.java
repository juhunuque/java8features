package java8features.methodreference;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    static Consumer<Student> c1 = p -> System.out.println(p);
    static Consumer<Student> c2 = Student::printListOfActivities;
    public static void main(String[] args) {

        StudentDataBase.getAllStudents()
                .forEach(c2);

    }
}
