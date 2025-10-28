package rosa.ribeiro.jonas;

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


public class CreatureEngine {
    private Creature creature;
    private final Random random = new Random();


    public CreatureEngine(Creature creature) {
        this.creature = creature;
    }

    public Creature getCreature() {
        return creature;
    }

    public boolean isAlive() {
        return this.creature.getHp() > 0;
    }

    public void tickTackCreature(){
        creature.setThirst(creature.getThirst() + 1);
        creature.setStamina(creature.getStamina() - 1);
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

    private Coordinate wander(){
        Coordinate current = creature.getPosition();
        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;
        Coordinate next = new Coordinate(current.getX() + dx, current.getY() + dy);
        boolean moved = move(next);
        if(moved){
            creature.setPosition(next);
            return next;
        } else {
            return current;
        }
    }


    public boolean move(Coordinate newPosition){
        if(creature.getStamina() >= creature.getPosition().distanceTo(newPosition)){
            creature.setPosition(newPosition);
            creature.setStamina(Math.subtractExact(creature.getStamina(), ((int)creature.getPosition().distanceTo(newPosition))));
            return true;
        }
        return false;
    }

    public void rest(){
        creature.setStamina((creature.getStamina() + 2));
    }

    private Action createUseResourceAction(List<Resource> resources){
        List<Integer> list = new ArrayList<>();
        for(Resource resource: resources){
            list.add((int)creature.getPosition().distanceTo(resource.getPosition()));
        }
        int index = list.indexOf(Collections.min(list));
        return new UseResourceAction(resources.get(index).getPosition(), priorityByResourceType(resources.get(index).getResourceType()), this);

    }

    private Action createMoveAction(){
        Coordinate c = wander();
       return new MoveAction(c,this);
    }

    private Action createRestAction(){
        return new RestAction(this);
    }



    private int priorityByResourceType(ResourceType resourceType) {
        switch (resourceType) {
            case WATER:
                return creature.getThirst();

        }
        return -1;
    }

    //adicionar mais ações e escolher qual usar
    public Action getAction(List<Resource> resources){
        if(getCreature().getStaminaRatio() <= 25){
            return createRestAction();
        }
        if(getCreature().getThirst() >= getCreature().getThirstDangerZone()){
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
            """, creature.getNickname(), creature.getHp(), creature.getHungry(), creature.getStamina(), creature.getThirst(), creature.getPosition());
    }

}
