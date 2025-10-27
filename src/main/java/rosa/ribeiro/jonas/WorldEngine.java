package rosa.ribeiro.jonas;

import rosa.ribeiro.jonas.actions.Action;
import rosa.ribeiro.jonas.resouces.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorldEngine {
    List<CreatureEngine> creatureEngines;
    List<Resource> resourceList;

    public WorldEngine(List<CreatureEngine> creatureEngines, List<Resource> resourceList) {
        this.creatureEngines = creatureEngines;
        this.resourceList = resourceList;
    }

    private int countAliveCreatures(){
        int countAliveCreature = 0;
        for(CreatureEngine creature: creatureEngines){
            if(creature.isAlive()){
                countAliveCreature++;
            }
        }
        return countAliveCreature;
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

    public void tickTack(){
        List<Action> actionList = new ArrayList<>();
        int alive = countAliveCreatures();
        for(CreatureEngine creature : creatureEngines){
            creature.tickTackCreature();
            actionList.add(creature.getAction(resourceList));
        }
        for(Action action: chooseActionOrder(actionList).values()){
            action.execute();
        }
    }







}
