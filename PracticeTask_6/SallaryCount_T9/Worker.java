/**
 * Worker
 */
public abstract class Worker {
    protected int mainSal = 2500000;
    private String name;

    public Worker(String name){
        this.name = name;
    }

    public abstract void  secondarySal(int num);

    public void statusPrint(){
        System.out.printf("%s mendapatkan gaji Rp. %d \n",name,mainSal);
    }

}