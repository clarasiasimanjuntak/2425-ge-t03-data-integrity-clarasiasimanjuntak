package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.*;

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Course> daftarMataKuliah = new ArrayList<>();
        List<Student> daftarMahasiswa = new ArrayList<>();
        List<Enrollment> daftarPendaftaran = new ArrayList<>();

        while (true) {
            String masukan = sc.nextLine();
            if (masukan.equals("---")) break;

            String[] data = masukan.split("#");
            if (data.length > 1) {
                String perintah = data[0].trim();
                try {
                    switch (perintah) {
                        case "course-add":
                            if (data.length == 5) {
                                Course mataKuliah = new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]);
                                if (!daftarMataKuliah.contains(mataKuliah)) {
                                    daftarMataKuliah.add(mataKuliah);
                                }
                            }
                            break;

                        case "student-add":
                            if (data.length == 5) {
                                Student mahasiswa = new Student(data[1], data[2], data[3], data[4]);
                                if (!daftarMahasiswa.contains(mahasiswa)) {
                                    daftarMahasiswa.add(mahasiswa);
                                }
                            }
                            break;

                        case "enrollment-add":
                            if (data.length == 5) {
                                String kodeMataKuliah = data[1];
                                String nimMahasiswa = data[2];
                                
                                boolean mataKuliahAda = daftarMataKuliah.stream()
                                    .anyMatch(c -> c.getCourseCode().equals(kodeMataKuliah));
                                boolean mahasiswaAda = daftarMahasiswa.stream()
                                    .anyMatch(s -> s.getStudentId().equals(nimMahasiswa));
                                
                                if (!mataKuliahAda) {
                                    System.out.println("invalid course|" + kodeMataKuliah);
                                }
                                if (!mahasiswaAda) {
                                    System.out.println("invalid student|" + nimMahasiswa);
                                }
                                
                                if (mataKuliahAda && mahasiswaAda) {
                                    daftarPendaftaran.add(new Enrollment(kodeMataKuliah, nimMahasiswa, data[3], data[4], "None"));
                                }
                            }
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        sc.close();

        // Urutkan sebelum mencetak
        daftarMataKuliah.sort(Comparator.comparing(Course::getCourseCode));
        daftarMahasiswa.sort(Comparator.comparing(Student::getStudentId));
        daftarPendaftaran.sort(Comparator.comparing(Enrollment::getCourseCode)
                        .thenComparing(Enrollment::getStudentId));

        // Cetak semua data
        for (Course mk : daftarMataKuliah) {
            System.out.println(mk);
        }
        for (Student mhs : daftarMahasiswa) {
            System.out.println(mhs);
        }
        for (Enrollment daftar : daftarPendaftaran) {
            System.out.println(daftar);
        }
    }
}