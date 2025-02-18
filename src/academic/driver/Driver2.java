package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.*;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Course> courses = new TreeMap<>();
        Map<String, Student> students = new TreeMap<>();
        Map<String, List<Enrollment>> enrollmentsByStudent = new TreeMap<>();

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
                            // Initialize empty enrollment list for new student
                            enrollmentsByStudent.putIfAbsent(data[1], new ArrayList<>());
                        }
                        break;

                    case "enrollment-add":
                        if (data.length == 5) {
                            String courseCode = data[1];
                            String studentId = data[2];
                            
                            if (!courses.containsKey(courseCode)) {
                                System.out.println("invalid course|" + courseCode);
                                continue;
                            }
                            if (!students.containsKey(studentId)) {
                                System.out.println("invalid student|" + studentId);
                                continue;
                            }
                            
                            Enrollment enrollment = new Enrollment(courseCode, studentId, data[3], data[4], "None");
                            enrollmentsByStudent.get(studentId).add(enrollment);
                        }
                        break;

                    case "student-enrollment-print":
                        if (data.length == 2) {
                            String studentId = data[1];
                            Student student = students.get(studentId);
                            if (student != null) {
                                System.out.println(student);
                                List<Enrollment> studentEnrollments = enrollmentsByStudent.getOrDefault(studentId, new ArrayList<>());
                                
                                // Sort enrollments by course code
                                studentEnrollments.sort((e1, e2) -> e1.getCourseCode().compareTo(e2.getCourseCode()));
                                
                                for (Enrollment enrollment : studentEnrollments) {
                                    Course course = courses.get(enrollment.getCourseCode());
                                    if (course != null) {
                                        System.out.println(course);
                                        System.out.println(enrollment);
                                    }
                                }
                            }
                        }
                        break;
                }
            }
        }
        sc.close();
    }
}