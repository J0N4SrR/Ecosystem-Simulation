package rosa.ribeiro.jonas.actions;

import rosa.ribeiro.jonas.creatures.LifeManager;
import rosa.ribeiro.jonas.world.Coordinate;

public class WaitAction implements Action{

    private LifeManager lifeManager;
    private Coordinate coordinate;
    private ActionType actionType;



    public WaitAction(LifeManager lifeManager) {
        this.lifeManager = lifeManager;
        this.coordinate = lifeManager.getCreature().getPosition();
        this.actionType = ActionType.WAIT;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public int getActionPriority() {
        return 1;
    }

    @Override
    public ActionType getActionType() {
        return actionType;
    }

    @Override
    public void execute() {

    }
}
