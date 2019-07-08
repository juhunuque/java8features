package java8features.streams;

import java8features.data.StudentDataBase;

public class StreamsMatchExample {

    public static boolean allMatch() {
        return StudentDataBase.getAllStudents().stream()
                .allMatch(s -> s.getGpa() >= 3.9);
    }

    public static boolean anyMatch() {
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(s -> s.getGpa() >= 4.0);
    }

    public static boolean noneMatch() {
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(s -> s.getGpa() >= 4.1);
    }

    public static void main(String[] args) {
        System.out.println("allMatch() : " + allMatch());
        System.out.println("anyMatch() : " + anyMatch());
        System.out.println("noneMatch() : " + noneMatch());

    }
}
