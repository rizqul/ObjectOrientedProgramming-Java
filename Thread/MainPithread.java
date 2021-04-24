
public class MainPithread {
    public static void main(String[] args) {
        PiThread piThread = new PiThread();
        piThread.start();

        try {
            Thread.sleep(1000);
            System.out.println("Calculating...");
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("pi = "+piThread.pi);
    }
}