package rosa.ribeiro.jonas.actions;

import rosa.ribeiro.jonas.creatures.LifeManager;
import rosa.ribeiro.jonas.world.Coordinate;

public class HuntAction implements Action{
    private ActionType actionType;
    private LifeManager lifeManager;
    private LifeManager target;

    public HuntAction(ActionType actionType, LifeManager lifeManager, LifeManager target) {
        this.actionType = ActionType.HUNT;
        this.lifeManager = lifeManager;
        this.target = target;
    }

    @Override
    public Coordinate getCoordinate() {
        return null;
    }

    @Override
    public int getActionPriority() {
        int max = lifeManager.getCreature().getLifeStatus().getHungryMax();
        int current = lifeManager.getCreature().getLifeStatus().getHungry();
        return (max == 0) ? 0 : (current * 100) / max;
    }

    @Override
    public ActionType getActionType() {
        return actionType;
    }

    @Override
    public void execute() {

    }
}
