public class Main {
    public static void main(String[] args) {
        MataKuliah matkul1 = new MataKuliah("PBO", 3, "pak supri");
        Mahasiswa m1  = new Mahasiswa();
        m1.joinClass(matkul1);
        m1.showData();
    }
}