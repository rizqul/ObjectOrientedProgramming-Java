public class Staff extends Worker {

    public Staff(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void secondarySal(int num) {
        mainSal += num * 50000;
    }
    
}