package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.*;

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Course> courses = new TreeMap<>();
        Map<String, Student> students = new TreeMap<>();
        List<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;

            String[] data = input.split("#");
            if (data.length > 1) {
                String command = data[0].trim();
                
                switch (command) {
                    case "course-add":
                        if (data.length == 5) {
                            Course course = new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]);
                            courses.putIfAbsent(data[1], course);
                        }
                        break;

                    case "student-add":
                        if (data.length == 5) {
                            Student student = new Student(data[1], data[2], data[3], data[4]);
                            students.putIfAbsent(data[1], student);
                        }
                        break;

                    case "enrollment-add":
                        if (data.length == 5) {
                            String courseCode = data[1];
                            String studentId = data[2];
                            
                            if (!courses.containsKey(courseCode)) {
                                System.out.println("        invalid course|" + courseCode);
                            }
                            if (!students.containsKey(studentId)) {
                                System.out.println("        invalid student|" + studentId);
                            }
                            
                            if (courses.containsKey(courseCode) && students.containsKey(studentId)) {
                                enrollments.add(new Enrollment(courseCode, studentId, data[3], data[4], "None"));
                            }
                        }
                        break;
                }
            }
        }
        sc.close();

        // Print courses
        for (Course course : courses.values()) {
            System.out.println("        " + course);
        }

        // Print students
        for (Student student : students.values()) {
            System.out.println("        " + student);
        }

        // Sort and print enrollments
        enrollments.sort((e1, e2) -> {
            int cmp = e1.getCourseCode().compareTo(e2.getCourseCode());
            if (cmp == 0) {
                return e1.getStudentId().compareTo(e2.getStudentId());
            }
            return cmp;
        });
        
        for (Enrollment enrollment : enrollments) {
            System.out.println("        " + enrollment);
        }
    }
}