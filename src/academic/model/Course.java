package academic.model;

import java.util.Objects;

public class Course {
    private final String courseCode;
    private final String courseName;
    private final int sks;
    private final String grade;

    public Course(String courseCode, String courseName, int sks, String grade) {
        if (courseCode == null || courseCode.isEmpty() || courseName == null || courseName.isEmpty()) {
            throw new IllegalArgumentException("Kode dan nama mata kuliah tidak boleh kosong!");
        }
        if (sks <= 0) {
            throw new IllegalArgumentException("SKS harus lebih dari 0!");
        }
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.sks = sks;
        this.grade = grade;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String toString() {
        return courseCode + "|" + courseName + "|" + sks + "|" + grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return courseCode.equals(course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
}
