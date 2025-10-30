package rosa.ribeiro.jonas.creatures;

import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.actions.Action;
import rosa.ribeiro.jonas.actions.MoveAction;
import rosa.ribeiro.jonas.actions.RestAction;
import rosa.ribeiro.jonas.actions.UseResourceAction;
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
        return this.creature.getLifeManager().getHp() > 0;
    }

    public void tickTackCreature(){
        creature.getLifeManager().setThirst(creature.getLifeManager().getThirst() + 1);
        creature.getLifeManager().setStamina(creature.getLifeManager().getStamina() - 1);
        creature.getLifeManager().setHungry(creature.getLifeManager().getHungry() + 1);
        if(creature.getLifeManager().getHungry() == creature.getLifeManager().getHungryMax()){
            creature.getLifeManager().setHp(creature.getLifeManager().getHp() - 1);
        }
    }

    private int getWaterDuration(){
        int duration = 0;
            for(int i = 1; i <= creature.getLifeManager().getThirst(); i++){
                duration++;
            }
        return duration;
    }

    private int drink(){
        int time = getWaterDuration();
        creature.getLifeManager().setThirst(0);
        return time;

    }

    private void eat(){
        creature.getLifeManager().setHungry(0);
    }

    public void actionByResourceType(ResourceType resourceType){
        switch (resourceType){
            case WATER -> drink();
            case MEAT, PLANT -> eat();
        }
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
        return creature.getLifeManager().getStamina() >= creature.getPosition().distanceTo(newPosition);
    }

    public boolean move(Coordinate newPosition){
        if(hasEnergy(newPosition)){
            creature.setPosition(newPosition);
            creature.getLifeManager().setStamina(Math.subtractExact(creature.getLifeManager().getStamina(), ((int)creature.getPosition().distanceTo(newPosition))));
            return true;
        }
        return false;
    }

    public void rest(){
        creature.getLifeManager().setStamina((creature.getLifeManager().getStamina() + 4));
    }

    private Action createUseResourceAction(List<Resource> resources){
        List<Integer> list = new ArrayList<>();
        for(Resource resource: resources){
            list.add((int)creature.getPosition().distanceTo(resource.getPosition()));
        }
        int index = list.indexOf(Collections.min(list));
        return new UseResourceAction(resources.get(index), this);

    }

    private Action createMoveAction(){

       return new MoveAction(this);
    }

    private Action createRestAction(){
        return new RestAction(this);
    }



    public int priorityByResourceType(ResourceType resourceType) {
        return switch (resourceType) {
            case WATER -> creature.getLifeManager().getThirst();
            case PLANT, MEAT -> creature.getLifeManager().getHungry();
            default -> -1;
        };
    }

    //adicionar mais ações e escolher qual usar
    public Action getAction(List<Resource> resources){
        if(((getCreature().getLifeManager().getStamina())*100/getCreature().getLifeManager().getStaminaMax()) <= 25){
            return createRestAction();
        }
        if(getCreature().getLifeManager().getThirst() >= (getCreature().getLifeManager().getThirstMax())/2){
            return createUseResourceAction(resources);
        }
        if(getCreature().getLifeManager().getHungry() >= (int)(getCreature().getLifeManager().getHungryMax() * 0.7)){
            return createUseResourceAction(resources);
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
            """, creature.getNickname(), creature.getLifeManager().getHp(), creature.getLifeManager().getHungry(), creature.getLifeManager().getStamina(), creature.getLifeManager().getThirst(), creature.getPosition());
    }

}
