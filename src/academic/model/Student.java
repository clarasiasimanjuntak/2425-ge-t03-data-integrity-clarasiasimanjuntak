package academic.model;

import java.util.Objects;

public class Student {
    private final String studentId;
    private final String studentName;
    private final String academicYear;
    private final String semester;

    public Student(String studentId, String studentName, String academicYear, String semester) {
        if (studentId == null || studentId.isEmpty() || studentName == null || studentName.isEmpty()) {
            throw new IllegalArgumentException("ID dan nama mahasiswa tidak boleh kosong!");
        }
        this.studentId = studentId;
        this.studentName = studentName;
        this.academicYear = academicYear;
        this.semester = semester;
    }

    public String getStudentId() {
        return studentId;
    }

    public String toString() {
        return studentId + "|" + studentName + "|" + academicYear + "|" + semester;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
