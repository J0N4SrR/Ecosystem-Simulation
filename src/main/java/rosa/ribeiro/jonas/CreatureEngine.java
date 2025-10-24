package rosa.ribeiro.jonas;

import rosa.ribeiro.jonas.resouces.Resource;
import rosa.ribeiro.jonas.resouces.ResourceType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreatureEngine {
    private Creature creature;


    public boolean isAlive() {
        return this.creature.getHp() > 0;
    }

    private int getWaterDuration(){
        int duration = 0;
            for(int i = 1; i <= creature.getThirst(); i++){
                duration++;
            }
        return duration;
    }

    public int drinkWater(){
        int time = getWaterDuration();
        creature.setThirst(0);
        return time;

    }

    public boolean move(Coordinate newPosition){
        if(creature.getStamina() >= creature.getPosition().distanceTo(newPosition)){
            creature.setPosition(newPosition);
            creature.setStamina(Math.subtractExact(creature.getStamina(), ((int)creature.getPosition().distanceTo(newPosition))));
            return true;
        }
        return false;
    }

    public Action createUseResourceAction(List<Resource> resources){
        List<Integer> list = new ArrayList<>();
        for(Resource resource: resources){
            list.add((int)creature.getPosition().distanceTo(resource.getPosition()));
        }
        int index = list.indexOf(Collections.min(list));
        return new UseResourceAction(resources.get(index).getPosition(), priorityByResourceType(resources.get(index).getResourceType()), this);

    }

    private int priorityByResourceType(ResourceType resourceType) {
        switch (resourceType) {
            case WATER:
                return creature.getThirst();

        }
        return -1;
    }






}
