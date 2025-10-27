package rosa.ribeiro.jonas.actions;

import rosa.ribeiro.jonas.Coordinate;
import rosa.ribeiro.jonas.CreatureEngine;

public class RestAction implements Action {
    private Coordinate coordinate;
    private int priority;
    private ActionType actionType;
    private CreatureEngine creatureEngine;

    public RestAction(Coordinate coordinate, int priority, ActionType actionType, CreatureEngine creatureEngine) {
        this.coordinate = coordinate;
        this.priority = priority;
        this.actionType = actionType;
        this.creatureEngine = creatureEngine;
    }

    @Override
    public Coordinate getCoordinate() {
        return null;
    }

    @Override
    public int getActionPriority() {
        return 0;
    }

    @Override
    public ActionType getActionType() {
        return null;
    }

    @Override
    public void execute() {

    }
}
