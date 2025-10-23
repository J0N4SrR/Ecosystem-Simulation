package rosa.ribeiro.jonas;

import java.util.List;

public class WorldEngine {
    List<CreatureEngine> creatureEngines;
    List<Resource> resourceList;

    public int countAliveCreatures(){
        int count = 0;
        for(CreatureEngine creature: creatureEngines){
            if(creature.isAlive()){
                count++;
            }
        }
        return count;
    }





}
