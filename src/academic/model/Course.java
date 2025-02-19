/**
 * 12S23019 - Clarasia Simanjuntak 
 * 12S23043 - Grace Tiodora
 */
package academic.model;

import java.util.Objects;

public class Course {
    private final String courseCode;
    private final String courseName;
    private final int credits;
    private final String grade;

    public Course(String courseCode, String courseName, int credits, String grade) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.grade = grade;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getCredits() {
        return credits;
    }
    public String getGrade() {
        return grade;
    }
    public String toString() {
        return courseCode + "|" + courseName + "|" + credits + "|" + grade;
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