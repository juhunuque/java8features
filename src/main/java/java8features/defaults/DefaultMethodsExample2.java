package java8features.defaults;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodsExample2 {

    public static Consumer<Student> studentConsumer = s -> System.out.println(s);
    public static Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
    public static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    public static Comparator<Student> gradeComparator = Comparator.comparingDouble(Student::getGradeLevel);


    public static void sortByName(List<Student> studentList) {
        System.out.println("After sortByName");

        studentList.sort(nameComparator);
        studentList.forEach(studentConsumer);
    }

    public static void sortByGPA(List<Student> studentList) {
        System.out.println("After sortByGPA");

        studentList.sort(gpaComparator);
        studentList.forEach(studentConsumer);
    }

    public static void comparatorChaining(List<Student> studentList) {
        System.out.println("After comparatorChaining");
        studentList.sort(gradeComparator.thenComparing(nameComparator));

        studentList.forEach(studentConsumer);

    }

    public static void sortWIthNullValues(List<Student> studentList) {
        System.out.println("After sortWIthNullValues");
        Comparator<Student> studentComparator = Comparator.nullsFirst(nameComparator);

        studentList.sort(studentComparator);

        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("Before Sort");
        studentList.forEach(studentConsumer);

        sortByName(studentList);
        sortByGPA(studentList);
        comparatorChaining(studentList);
        sortWIthNullValues(studentList);
    }
}
