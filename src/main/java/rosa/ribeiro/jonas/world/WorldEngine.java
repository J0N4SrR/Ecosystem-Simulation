package rosa.ribeiro.jonas.world;

import rosa.ribeiro.jonas.actions.Action;
import rosa.ribeiro.jonas.creatures.LifeManager;
import rosa.ribeiro.jonas.resouces.Meat;
import rosa.ribeiro.jonas.resouces.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorldEngine {
    List<LifeManager> lifeManagers;
    List<Resource> resourceList;

    public WorldEngine(List<LifeManager> lifeManagers, List<Resource> resourceList) {
        this.lifeManagers = lifeManagers;
        this.resourceList = resourceList;
    }


    public HashMap<Coordinate, Action>  chooseActionOrder(List<Action> actionList){
        HashMap<Coordinate, Action> winners = new HashMap<>();
        for(Action action: actionList){
            if(winners.containsKey(action.getCoordinate())){
                if(action.getActionPriority() > winners.get(action.getCoordinate()).getActionPriority()){
                    winners.put(action.getCoordinate(),action);
                    continue;
                } else {
                    continue;
                }
            }
            winners.put(action.getCoordinate(),action);
        }
        return winners;
    }

    public void tickTack() {
        List<Action> actionList = new ArrayList<>();
        int alive = 0;
        List<LifeManager> creatureRem = new ArrayList<>();
        for (LifeManager creature : lifeManagers) {
            creature.tickTackCreature();
            if (creature.isAlive()) {
                alive++;
            } else {
                int x = creature.getCreature().getPosition().getX();
                int y = creature.getCreature().getPosition().getY();
                String name = "meat" + creature.getCreature().getNickname();
                Resource meat = new Meat("name", new Coordinate(x, y), (creature.getCreature().getLifeStatus().getHp()), 3);
                resourceList.add(meat);
                creatureRem.add(creature);
            }
            actionList.add(creature.getAction(resourceList));
        }
        lifeManagers.removeAll(creatureRem);

        for (Action action : chooseActionOrder(actionList).values()) {
            action.execute();
        }
        System.out.println(" CRIATURAS VIVAS: " + alive);
        System.out.println("########################################");
        System.out.println(lifeManagers);

    }







}
