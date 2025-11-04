package rosa.ribeiro.jonas.creatures;

import rosa.ribeiro.jonas.actions.*;
import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.resouces.Resource;
import rosa.ribeiro.jonas.resouces.ResourceType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class LifeManager {
    private final Creature creature;
    private final Random random = new Random();


    public LifeManager(Creature creature) {
        this.creature = creature;
    }

    public Creature getCreature() {
        return creature;
    }

    public boolean isAlive() {
        return this.creature.getLifeStatus().getHp() > 0;
    }

    public void tickTackCreature(){
        creature.getLifeStatus().setThirst(creature.getLifeStatus().getThirst() + 1);
        creature.getLifeStatus().setStamina(creature.getLifeStatus().getStamina() - 1);
        creature.getLifeStatus().setHungry(creature.getLifeStatus().getHungry() + 1);
        if(creature.getLifeStatus().getHungry() == creature.getLifeStatus().getHungryMax()){
            creature.getLifeStatus().setHp(creature.getLifeStatus().getHp() - 1);
        }
    }

    private void drink(){
        creature.getLifeStatus().setThirst(0);
    }

    private void eat(){
        creature.getLifeStatus().setHungry(0);
    }

    public void actionByResourceType(ResourceType resourceType){
        switch (resourceType){
            case WATER -> drink();
            case MEAT, PLANT -> eat();
        }
    }

    public ResourceType seekResourceByCreatureType(){
        switch (creature.getCreatureCategory()){
            case HUNTER -> {
                return ResourceType.MEAT;
            }
            case PREY -> {
                return ResourceType.PLANT;
            }
        }
        return null;
    }



    public Coordinate wander(){
        Coordinate current = this.creature.getPosition();
        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;
        Coordinate next = new Coordinate(current.getX() + dx, current.getY() + dy);

        if(hasEnergy(next)){
            return next;
        } else {
            return current;
        }
    }

    public boolean hasEnergy(Coordinate newPosition){
        return creature.getLifeStatus().getStamina() >= creature.getPosition().distanceTo(newPosition);
    }

    public boolean move(Coordinate newPosition){
        if(hasEnergy(newPosition)){
            creature.setPosition(newPosition);
            creature.getLifeStatus().setStamina(Math.subtractExact(creature.getLifeStatus().getStamina(), ((int)creature.getPosition().distanceTo(newPosition))));
            return true;
        }
        return false;
    }

    public void rest(){
        creature.getLifeStatus().setStamina((creature.getLifeStatus().getStaminaMax()));
    }

    private Action createUseResourceAction(List<Resource> resources, ResourceType resourceType){
        Resource bestResource = null;
        double minDistance = Double.MAX_VALUE;
        for(Resource resource: resources){
            if(resource.getResourceType().equals(resourceType)){
                double distance = creature.getPosition().distanceTo(resource.getPosition());
                if (distance < minDistance){
                    minDistance = distance;
                    bestResource = resource;
                }
            }
        }
        if(bestResource != null) {
            return new UseResourceAction(bestResource, this);
        }

        return new WaitAction(this);
    }

    private Action createMoveAction(){
       return new MoveAction(this);
    }

    private Action createRestAction(){
        return new RestAction(this);
    }



    public int priorityByResourceType(ResourceType resourceType) {
        return switch (resourceType) {
            case WATER -> {
                int max = creature.getLifeStatus().getThirstMax();
                int current = creature.getLifeStatus().getThirst();
                yield (max == 0) ? 0 : (current * 100) / max;
            }
            case PLANT, MEAT -> {
                int max = creature.getLifeStatus().getHungryMax();
                int current = creature.getLifeStatus().getHungry();
                yield (max == 0) ? 0 : (current * 100) / max;

            }
            default -> 0;
        };
    }

    //adicionar mais ações e escolher qual usar
    public Action getAction(List<Resource> resources){
        if(getCreature().getLifeStatus().getStamina()< (int)(((getCreature().getLifeStatus().getStaminaMax())*0.25))){
            return createRestAction();
        }
        if(getCreature().getLifeStatus().getThirst() >= (getCreature().getLifeStatus().getThirstMax())/2){
            return createUseResourceAction(resources, ResourceType.WATER);
        }
        if(getCreature().getLifeStatus().getHungry() >= (int)(getCreature().getLifeStatus().getHungryMax() * 0.7)){
            return createUseResourceAction(resources, seekResourceByCreatureType());
        }


        return createMoveAction();

    }


    @Override
    public String toString() {
        return String.format("""
            🧬 Creature: %s
              • HP: %d
              • Fome: %d
              • Stamina: %d
              • Sede: %d
              • Posição: %s
            """, creature.getNickname(), creature.getLifeStatus().getHp(), creature.getLifeStatus().getHungry(), creature.getLifeStatus().getStamina(), creature.getLifeStatus().getThirst(), creature.getPosition());
    }

}
