package rosa.ribeiro.jonas;

public class CreatureEngine {


    private int getActiveDuration(Creature creature, Resource resource){
        int activeDuration = 0;
            for(int i = 1; i <= creature.getThirst(); i++){
                activeDuration++;
            }
        return activeDuration;
    }
}
