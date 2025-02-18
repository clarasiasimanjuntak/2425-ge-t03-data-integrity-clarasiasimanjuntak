/**
 * 12S23019 - Clarasia Simanjuntak 
 * 12S23043 - Grace Tiodora
 */
package academic.model;

import java.util.Objects;

public class Student {
    private final String studentId;
    private final String studentName;
    private final String academicYear;
    private final String major;

    public Student(String studentId, String studentName, String academicYear, String major) {
        if (studentId == null || studentId.isEmpty() || studentName == null || studentName.isEmpty()) {
            throw new IllegalArgumentException("Student ID and name cannot be empty!");
        }
        this.studentId = studentId;
        this.studentName = studentName;
        this.academicYear = academicYear;
        this.major = major;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public String getAcademicYear() {
        return academicYear;
    }
    public String getMajor() {
        return major;
    }
    @Override
    public String toString() {
        return studentId + "|" + studentName + "|" + academicYear + "|" + major;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}