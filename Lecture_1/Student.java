public class Student {
    String name;
    String nim;
    private double ipk;

    public int setIpk(double ipk){
        this.ipk =  ipk;
        int a = (int) ipk;
        System.out.println(ipk);

        return a;
    }

}