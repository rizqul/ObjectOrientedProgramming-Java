
public class PiThread extends Thread {
    boolean negative = true;
    double pi;
    @Override
    public void run() {
        for (int i = 3; i < 1000000 ; i+=2) {
            if (negative) {
                pi -= (1.0/i);
            } else {
                pi += (1.0/i);
            }
            negative = !negative;
        }
        pi += 1.0;
        pi *= 4.0;
        System.out.println("PiThread stopped");
    }
}