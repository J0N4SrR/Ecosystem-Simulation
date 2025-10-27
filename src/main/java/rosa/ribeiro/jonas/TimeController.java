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

        while(true){
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
