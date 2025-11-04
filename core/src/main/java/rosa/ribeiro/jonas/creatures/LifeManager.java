package rosa.ribeiro.jonas.creatures;

import rosa.ribeiro.jonas.actions.*;
import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.resouces.Resource;
import rosa.ribeiro.jonas.resouces.ResourceType;

import java.util.*;


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

    private LifeManager targetCreature(List<LifeManager> lifeManagersTarget){
        double minDist = Double.MAX_VALUE;
        LifeManager targetCreature = null;
        for(LifeManager creature : lifeManagersTarget){
            if(creature.getCreature().getCreatureCategory().equals(CreatureCategory.PREY)){
                double position = creature.getCreature().getPosition().distanceTo(this.getCreature().getPosition());
                if(position < minDist){
                    minDist = position;
                    targetCreature = creature;
                }
            }
        }
        return targetCreature;
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

    private Action createWaitAction(){
        return new WaitAction(this);
    }

    private Action createHunterAction(List<LifeManager> target){
       LifeManager targetCreature = targetCreature(target);
       return new HuntAction(this, targetCreature);

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
    public Action getAction(List<Resource> resources, List<LifeManager> creatures){
        List<Action> actionList = new ArrayList<>();
        actionList.add(createRestAction());
        actionList.add(createUseResourceAction(resources, ResourceType.WATER));
        actionList.add(createUseResourceAction(resources, seekResourceByCreatureType()));
        actionList.add(createMoveAction());
        if(this.getCreature().getCreatureCategory().equals(CreatureCategory.HUNTER)){
            actionList.add(createHunterAction(creatures));
        }
        return Collections.max(actionList, Comparator.comparing(Action::getActionPriority));

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
