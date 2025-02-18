/**
 * 12S23019 - Clarasia Simanjuntak
 * 12S23043 - Grace Tiodora
 */
package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break; // Stop input saat ada "---"

            String[] data = input.split("#");

            if (data.length > 1) {
                String command = data[0]; // Ambil jenis perintah
                
                switch (command) {
                    case "course-add":
                        if (data.length == 5) { // Harus ada 5 bagian
                            String courseCode = data[1];
                            String courseName = data[2];
                            int sks = Integer.parseInt(data[3]); // Parsing integer
                            String grade = data[4];
                            courses.add(new Course(courseCode, courseName, sks, grade));
                        }
                        break;

                    case "student-add":
                        if (data.length == 5) { // Harus ada 5 bagian
                            String studentId = data[1];
                            String studentName = data[2];
                            String academicYear = data[3]; // Menggunakan String
                            String semester = data[4];
                            students.add(new Student(studentId, studentName, academicYear, semester));
                        }
                        break;

                    case "enrollment-add":
                        if (data.length == 5) {
                            String courseCode = data[1];
                            String studentId = data[2];
                            String academicYear = data[3]; // Menggunakan String
                            String semester = data[4];
                            enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester, "None"));
                        }
                        break;

                    default:
                        System.out.println("Perintah tidak dikenali: " + command);
                        break;
                }
            }
            
        }

        sc.close();

        // Cetak semua Course
        for (Course c : courses) {
            System.out.println(c);
        }

        // Cetak semua Student
        for (Student s : students) {
            System.out.println(s);
        }

        // Cetak semua Enrollment
        for (Enrollment e : enrollments) {
            System.out.println(e);
        }
    }
}
