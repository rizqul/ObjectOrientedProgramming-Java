import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Staff s1 = new Staff("jooj");
        Lecturer l1 = new Lecturer("Jaaj");

        System.out.println("jumlah kehadiran : ");
        s1.secondarySal(sc.nextInt());
        s1.statusPrint();

        System.out.println("jumlah SKS : ");
        l1.secondarySal(sc.nextInt());
        l1.statusPrint();

        sc.close();
    }
}