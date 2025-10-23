package rosa.ribeiro.jonas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreatureEngine {
    private Creature creature;


    public boolean isAlive() {
        return this.creature.getHp() > 0;
    }

    public int getWaterDuration(Creature creature, Resource resource){
        int activeDuration = 0;
            for(int i = 1; i <= creature.getThirst(); i++){
                activeDuration++;
            }
        return activeDuration;
    }


    public boolean seekResource(Coordinate newPosition){
        if(creature.getStamina() >= creature.getPosition().distanceTo(newPosition)){
            creature.setPosition(newPosition);
            creature.setStamina(Math.subtractExact(creature.getStamina(), ((int)creature.getPosition().distanceTo(newPosition))));
            return true;
        }
        return false;
    }

    public Coordinate takeMinDistance(List<Resource> resources){
        List<Integer> list = new ArrayList<>();
        for(Resource resource: resources){
            list.add((int)creature.getPosition().distanceTo(resource.getPosition()));
        }
        int index = list.indexOf(Collections.min(list));
        return resources.get(index).getPosition();
    }




}
