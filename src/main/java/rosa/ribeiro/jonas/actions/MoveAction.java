package rosa.ribeiro.jonas.actions;

import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.creatures.CreatureEngine;

public class MoveAction implements Action{
    private Coordinate coordinate;
    private ActionType actionType;
    private CreatureEngine creatureEngine;


    public MoveAction(CreatureEngine creatureEngine) {
        this.actionType = ActionType.MOVE;
        this.creatureEngine = creatureEngine;
        this.coordinate = creatureEngine.wander();

    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public int getActionPriority() {
        return creatureEngine.getCreature().getStamina();
    }

    @Override
    public ActionType getActionType() {
        return actionType;
    }

    @Override
    public void execute() {
        if(creatureEngine.getCreature().getPosition().equals(getCoordinate())){
            System.out.println("\n " + creatureEngine.getCreature().getNickname() + " está cansado e não se moveu." + getCoordinate());
        } else {
            System.out.println("\n " + creatureEngine.getCreature().getNickname() + " moveu-se para " + getCoordinate());
            creatureEngine.move(getCoordinate());
        }
    }
}
