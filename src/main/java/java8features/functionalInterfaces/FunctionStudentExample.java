package java8features.functionalInterfaces;

import java8features.data.Student;
import java8features.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {

    static Function<List<Student>, Map<String, Double>> studentFuntion = (students -> {
       Map<String, Double> studentGradeMap = new HashMap<>();

       students
               .forEach((student -> {
                   if(PredicateStudentExample.p1.test(student)) {
                       studentGradeMap.put(student.getName(), student.getGpa());
                   }
               }));

       return studentGradeMap;
    });

    public static void main(String[] args) {
        System.out.println(studentFuntion.apply(StudentDataBase.getAllStudents()));

    }
}
