package rosa.ribeiro.jonas;


public class TimeController implements Runnable{
    private int count;
    private WorldEngine worldEngine;

    public TimeController(WorldEngine worldEngine) {
        this.count = 0;
        this.worldEngine = worldEngine;
    }

    @Override
    public void run() {

        while(count < 10){
            count++;
            worldEngine.tickTack();
            try {
                Thread.sleep(1000);
                if(count == 9){
                    System.out.println(worldEngine.creatureEngines.toString());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
