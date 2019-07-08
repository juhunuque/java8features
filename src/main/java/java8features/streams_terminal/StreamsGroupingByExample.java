package java8features.streams_terminal;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsGroupingByExample {

    public static Map<String, List<Student>> groupStudentsByGender() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGender));
    }

    public static Map<String, List<Student>> customizedGroupStudentsByGender() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(s -> s.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));
    }

    public static Map<Integer, Map<String, List<Student>>> twoLevelGrouping_1() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(s -> s.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
    }

    public static Map<String, Integer> twoLevelGrouping_2() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getName,
                        Collectors.summingInt(Student::getNoteBooks)));
    }

    public static LinkedHashMap<String, Set<Student>> threeArgumentGroupBy() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getName,
                        LinkedHashMap::new, Collectors.toSet()));
    }

    public static Map<Integer, Optional<Student>> calculateToGpa() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.maxBy(Comparator.comparing(Student::getGpa))));
    }

    public static Map<Integer, Student> calculateMaxGpa2() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)),
                                Optional::get)));
    }

    public static Map<Integer, Student> calculateLeastGpa2() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa)),
                                Optional::get)));
    }

    public static void main(String[] args) {
        System.out.println("groupStudentsByGender : " + groupStudentsByGender());
        System.out.println("customizedGroupStudentsByGender : " + customizedGroupStudentsByGender());
        System.out.println("twoLevelGrouping_1 : " + twoLevelGrouping_1());
        System.out.println("twoLevelGrouping_2 : " + twoLevelGrouping_2());
        System.out.println("twoLevelGrouping_2 : " + twoLevelGrouping_2());
        System.out.println("calculateToGpa : " + calculateToGpa());
        System.out.println("calculateMaxGpa2 : " + calculateMaxGpa2());
        System.out.println("calculateLeastGpa2 : " + calculateLeastGpa2());

    }
}
