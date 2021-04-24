import java.util.ArrayList;

public class Race {
    public  int raceParticipants;
    private boolean raceStart = false;
    public ArrayList<String> runnersRank = new ArrayList<>();


    public boolean getRaceStart(){
        return raceStart;
    }
    
    public void start() {
        if (raceParticipants >= 3) {
            System.out.println("The race is started ...\n");
            raceStart = true;
        } else {
            System.out.println("The race cannot be started, runners are not enough");
        }
    }

    public void result(){
        while (runnersRank.size() != raceParticipants) {
            System.out.print("");
            continue;
        } 

        System.out.println("\nThe Race has ended\n");

        String[] ranking = {"1st", "2nd", "3rd"};
        
        for (int i = 0; i < runnersRank.size(); i++) {
            if (i < 3) {
                System.out.printf("%s : %s\n", ranking[i], runnersRank.get(i));
            } else if(i == 3) {
                System.out.println("\n" + runnersRank.get(i) + " loses");
            }
            else {
                System.out.println(runnersRank.get(i) + " loses");
            }
        }
    }
}