package rosa.ribeiro.jonas.world;


public class TimeController implements Runnable{
    private int count;
    private WorldEngine worldEngine;

    public TimeController(WorldEngine worldEngine) {
        this.count = 0;
        this.worldEngine = worldEngine;
    }

    @Override
    public void run() {

        while(count < 40){
            count++;
            worldEngine.tickTack();
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
