package tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.acts.core.Course;
import com.acts.core.Student;

public class Driver {
    public static void main(String[] args) {
        Map<String,Student> students = new HashMap<>();
        Scanner sc =new Scanner(System.in);


        ArrayList<Student> students1 = new ArrayList<>(students.values());

        // students details sorted as per GPA 
        
        students1
        .stream()
        .sorted((g1,g2) -> {
            if(g1.getGPA() < g2.getGPA()){
                return -1;
            }
            return 1;
        })
        .forEach(c -> System.out.println(c));
        
        // avg of gpa of students for specified course
        
        Course cr = Course.valueOf(sc.next().toUpperCase());
        double sum = students1.stream()
        .filter(s -> s.getEnrolledCourse().equals(cr))
        .mapToDouble(g -> g.getGPA())
        .sum();
        
        double count = students1
        .stream()
        .filter(s -> s.getEnrolledCourse().equals(cr))
        .mapToDouble(g -> g.getGPA())
        .count();
        
        System.out.println("Avg gpa " + sum/count);
        
        // displaying topper
        Student topper = students1
        .stream()
        .filter(s -> s.getEnrolledCourse().equals(cr))
        .max((g1,g2) -> {
            if(g1.getGPA() < g2.getGPA()) {
                return -1;
            }
            return 1;
        } )
        .orElseThrow();
        
        System.out.println("Topper's Gpa" + topper.getGPA());
        
        // displaying number of students who failed in particular subject
        long numberOfFailure = students1
        .stream()
        .filter(s -> s.getEnrolledCourse().equals(cr))
        .filter(s -> s.getGPA() < 5)
        .count();
        
        System.out.println("Number of failure = " + numberOfFailure);
        
        // displaying all students DETAILS
        students.forEach((k,v) -> System.out.println(v));
        
        sc.close();
    }
}
