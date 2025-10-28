package rosa.ribeiro.jonas.actions;

import rosa.ribeiro.jonas.Coordinate;
import rosa.ribeiro.jonas.CreatureEngine;

public class MoveAction implements Action{
    private Coordinate coordinate;
    private ActionType actionType;
    private CreatureEngine creatureEngine;


    public MoveAction(Coordinate coordinate, CreatureEngine creatureEngine) {
        this.coordinate = coordinate;
        this.actionType = ActionType.MOVE;
        this.creatureEngine = creatureEngine;
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
        Coordinate c = getCoordinate();
        if(creatureEngine.getCreature().getPosition().equals(c)){
            System.out.println("\n " + creatureEngine.getCreature().getNickname() + " está cansado e não se moveu." + c);
        } else {
            System.out.println("\n " + creatureEngine.getCreature().getNickname() + " moveu-se para " + c);

        }
    }
}
