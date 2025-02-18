package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.*;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;

            String[] data = input.split("#");
            if (data.length > 1) {
                String command = data[0].trim();
                try {
                    switch (command) {
                        case "course-add":
                            Course course = new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]);
                            if (!courses.contains(course)) {
                                courses.add(course);
                            }
                            break;
                        case "student-add":
                            Student student = new Student(data[1], data[2], data[3], data[4]);
                            if (!students.contains(student)) {
                                students.add(student);
                            }
                            break;
                        case "enrollment-add":
                            boolean courseExists = courses.stream().anyMatch(c -> c.getCourseCode().equals(data[1]));
                            boolean studentExists = students.stream().anyMatch(s -> s.getStudentId().equals(data[2]));
                            if (courseExists && studentExists) {
                                enrollments.add(new Enrollment(data[1], data[2], data[3], data[4], "None"));
                            } else {
                                if (!courseExists) {
                                    System.out.println("invalid course|" + data[1]);
                                }
                                if (!studentExists) {
                                    System.out.println("invalid student|" + data[2]);
                                }
                            }
                            break;
                        default:
                            System.out.println("Invalid command");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        sc.close();

        courses.sort(Comparator.comparing(Course::getCourseCode));
        students.sort(Comparator.comparing(Student::getStudentId));
        enrollments.sort(Comparator.comparing(Enrollment::getCourseCode).thenComparing(Enrollment::getStudentId));

        for (Course c : courses) {
            System.out.println(c);
        }
        for (Student s : students) {
            System.out.println(s);
        }
        for (Enrollment e : enrollments) {
            System.out.println(e);
        }
    }
}
