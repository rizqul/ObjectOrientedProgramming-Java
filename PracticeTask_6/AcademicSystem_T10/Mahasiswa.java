import java.util.Scanner;

public class Mahasiswa {
    String name;
    String nim;
    String kelas;
    String mKuliahName;
    MataKuliah mKuliah;
    double midMark;
    double finalMark;
    double cumulativeMark;

    Scanner sc = new Scanner(System.in);

    public Mahasiswa() {
        System.out.print("Nama : ");
        name = sc.nextLine();
        System.out.print("NIM : ");
        nim = sc.next();
        System.out.print("Kelas : ");
        kelas = sc.next();
        System.out.print("Mata Kuliah : ");
        mKuliahName = sc.next();
        System.out.print("Nilai UTS : ");
        midMark = sc.nextDouble();
        System.out.print("Nilai UAS : ");
        finalMark = sc.nextDouble();
    }

    public void joinClass(MataKuliah subjek) {
        if (mKuliahName.equalsIgnoreCase(subjek.name)) {
            this.mKuliah = subjek;
            System.out.println(subjek.name);
        } else {
            System.out.println("Matakuliah tersebut tidak ada");
            return;
        }
    }

    public void showData() {
        if (mKuliah != null) {
            cumulativeMark = (midMark + finalMark) / 2;
            System.out.println("NIM : " + nim);
            System.out.println("Nama : " + name);
            System.out.println("Mata Kuliah : " + mKuliah.name);
            System.out.println("SKS : " + mKuliah.sks);
            System.out.println("Dosen : " + mKuliah.dosen);
            System.out.println("Nilai UTS : " + midMark);
            System.out.println("Nilai UAS : " + finalMark);
            System.out.println("nilaiAkhir : " + cumulativeMark);

            if (cumulativeMark > 90) {
                System.out.println("Nilai Mutu  : A");
            } else if (cumulativeMark > 80) {
                System.out.println("Nilai Mutu  : B");
            } else if (cumulativeMark > 70) {
                System.out.println("Nilai Mutu  : C");
            } else if (cumulativeMark > 60) {
                System.out.println("Nilai Mutu  : D");
            } else {
                System.out.println("Nilai Mutu  : E");
            }
        } else {
            return;
        }

    }

}