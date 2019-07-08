package java8features.streams;

import java8features.data.Student;
import java8features.data.StudentDataBase;

public class StreamMapReduceExample {

    private static int noOfNoteBooks() {
        return StudentDataBase.getAllStudents().stream()
             .map(Student::getNoteBooks)
                .reduce(0, (b1, b2) -> b1 + b2);
    }

    private static int noOfNoteBooks2() {
        return StudentDataBase.getAllStudents().stream()
                .filter(((s -> s.getGradeLevel()>= 3)))
                .filter(s -> s.getGender().equals("female"))
                .map(Student::getNoteBooks)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("The number of books is : " + noOfNoteBooks2());
    }
}
