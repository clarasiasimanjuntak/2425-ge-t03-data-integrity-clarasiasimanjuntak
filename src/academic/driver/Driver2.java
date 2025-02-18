package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.*;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Gunakan TreeMap agar data courses dan students terurut ascending berdasarkan key
        Map<String, Course> courses = new TreeMap<>();
        Map<String, Student> students = new TreeMap<>();
        Map<String, List<Enrollment>> enrollmentsByStudent = new TreeMap<>();
        
        // List untuk menyimpan pesan error agar dicetak terlebih dahulu
        List<String> errorMessages = new ArrayList<>();
        
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
                            enrollmentsByStudent.putIfAbsent(data[1], new ArrayList<>());
                        }
                        break;
                        
                    case "enrollment-add":
                        if (data.length == 5) {
                            String courseCode = data[1];
                            String studentId = data[2];
                            
                            if (!courses.containsKey(courseCode)) {
                                errorMessages.add("invalid course|" + courseCode);
                                continue;
                            }
                            if (!students.containsKey(studentId)) {
                                errorMessages.add("invalid student|" + studentId);
                                continue;
                            }
                            
                            Enrollment enrollment = new Enrollment(courseCode, studentId, data[3], data[4], "None");
                            enrollmentsByStudent.get(studentId).add(enrollment);
                        }
                        break;
                }
            }
        }
        sc.close();
        
        // Cetak pesan error terlebih dahulu (dengan urutan sesuai terjadinya error)
        for (String err : errorMessages) {
            System.out.println(err);
        }
        
        // Cetak courses (TreeMap sudah mengurutkan berdasarkan kode course ascending)
        for (Course c : courses.values()) {
            System.out.println(c);
        }
        
        // Cetak students (TreeMap mengurutkan berdasarkan student id ascending)
        for (Student s : students.values()) {
            System.out.println(s);
        }
        
        // Kumpulkan semua enrollments dari masing-masing student
        List<Enrollment> enrollments = new ArrayList<>();
        for (List<Enrollment> list : enrollmentsByStudent.values()) {
            enrollments.addAll(list);
        }
        // Urutkan enrollments: pertama berdasarkan course code ascending, lalu student id ascending
        enrollments.sort((e1, e2) -> {
            int cmp = e1.getCourseCode().compareTo(e2.getCourseCode());
            if (cmp == 0) {
                return e1.getStudentId().compareTo(e2.getStudentId());
            }
            return cmp;
        });
        for (Enrollment e : enrollments) {
            System.out.println(e);
        }
    }
}
