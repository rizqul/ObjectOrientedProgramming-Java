public class Runner implements Runnable {
    private Integer number;
    private Thread thread;
    private Race race;

    public Runner(Integer number){
        this.number = number;
    }

	@Override
	public void run() {
        System.out.println(thread.getName() + " is Running ...");
        try {
            Thread.sleep(1000*race.raceParticipants);
        } catch (Exception e) {
            System.out.println(e);
        }

        synchronized(race.runnersRank) {
            race.runnersRank.add(thread.getName());
        }
    }
    
    public Runner joinRace(Race racer){
        if (race == null)
            racer.raceParticipants++;
            race = racer;
            thread = new Thread(this);
            thread.setName("Runner-" + number);
        return this;
    }

    public void start(){
        if (thread != null && race.getRaceStart()) {
            thread.start();
        } else if (thread == null) {
            System.out.printf("%s have not entered any race\n", thread.getName());
        } else if (!race.getRaceStart()) {
            System.out.printf("Hey %s, the race hasn't started yet\n", thread.getName());
        }
    }
}