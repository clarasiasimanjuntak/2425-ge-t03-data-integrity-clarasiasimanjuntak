package academic.model;

public class Enrollment {
    private final String kodeMataKuliah;
    private final String nimMahasiswa;
    private final String tahunAkademik;
    private final String semester;
    private final String nilai;

    public Enrollment(String kodeMataKuliah, String nimMahasiswa, String tahunAkademik, String semester, String nilai) {
        this.kodeMataKuliah = kodeMataKuliah;
        this.nimMahasiswa = nimMahasiswa;
        this.tahunAkademik = tahunAkademik;
        this.semester = semester;
        this.nilai = nilai;
    }

    public String getCourseCode() {
        return kodeMataKuliah;
    }

    public String getStudentId() {
        return nimMahasiswa;
    }

    public String toString() {
        return kodeMataKuliah + "|" + nimMahasiswa + "|" + tahunAkademik + "|" + semester + "|" + nilai;
    }
}