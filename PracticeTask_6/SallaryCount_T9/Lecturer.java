public class Lecturer extends Worker {

    public Lecturer(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void secondarySal(int num) {
        mainSal += num * 120000;
    }
    
}