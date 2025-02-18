package academic.model;

public class Enrollment {
    private final String courseCode;
    private final String studentId;
    private final String academicYear;
    private final String semester;
    private final String grade;

    public Enrollment(String courseCode, String studentId, String academicYear, String semester, String grade) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = grade;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public String toString() {
        return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }
}
