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
        return lifeManager.getCreature().getPosition();
    }

    @Override
    public int getActionPriority() {
        int maxStamina = lifeManager.getCreature().getLifeStatus().getStaminaMax();
        int currentStamina = lifeManager.getCreature().getLifeStatus().getStamina();
        int basePriority = 100;

        return (maxStamina - currentStamina) * basePriority / maxStamina;
    }

    @Override
    public ActionType getActionType() {
        return actionType;
    }

    @Override
    public void execute() {
        lifeManager.rest();
        System.out.println(lifeManager.getCreature().getNickname() + " descansou na posição: " + getCoordinate());

    }
}
