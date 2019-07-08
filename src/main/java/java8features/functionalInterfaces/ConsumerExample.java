package java8features.functionalInterfaces;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    static Consumer<Student> c1 = (s) -> System.out.println(s);
    static Consumer<Student> c2 = (s) -> System.out.print(s.getName());
    static Consumer<Student> c3 = (s) -> System.out.println(s.getActivities());



    public static void printName() {
        System.out.println("printName");
        List<Student> students = StudentDataBase.getAllStudents();
        students
                .forEach(c1);
    }

    public static void printNameAndActivities() {
        System.out.println("printNameAndActivities");
        List<Student> students = StudentDataBase.getAllStudents();

        students
                .forEach(c2.andThen(c3)); // consumer chaining
    }

    public static void printNameAndActivitiesUsingCondition() {
        System.out.println("printNameAndActivitiesUsingCondition");
        List<Student> students = StudentDataBase.getAllStudents();

        students
                .forEach(student -> {
                    if(student.getGradeLevel()>=3 && student.getGpa() >= 3.9){
                        c2.andThen(c3).accept(student);
                    }
                });
    }

    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

        c1.accept("java 8");
//        printName();
//        printNameAndActivities();
        printNameAndActivitiesUsingCondition();
    }
}
