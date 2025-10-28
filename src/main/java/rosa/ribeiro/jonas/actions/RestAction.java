package rosa.ribeiro.jonas.actions;

import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.creatures.LifeManager;

public class RestAction implements Action {
    private ActionType actionType;
    private LifeManager lifeManager;

    public RestAction(LifeManager lifeManager) {

        this.actionType = ActionType.REST;
        this.lifeManager = lifeManager;
    }

    @Override
    public Coordinate getCoordinate() {
        return lifeManager.getCreature().getLifeManager().getPosition();
    }

    @Override
    public int getActionPriority() {
        return lifeManager.getCreature().getLifeManager().getStamina();
    }

    @Override
    public ActionType getActionType() {
        return actionType;
    }

    @Override
    public void execute() {
        lifeManager.rest();
        System.out.println("\n " + lifeManager.getCreature().getNickname() + " descansou na posição: " + getCoordinate());

    }
}
