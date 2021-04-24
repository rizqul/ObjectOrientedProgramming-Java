public class Student_list {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "joni";
        student1.nim = "jono";
        double ipk = 31.124;
        student1.setIpk(ipk);

        System.out.println(student1.name);


    }
}