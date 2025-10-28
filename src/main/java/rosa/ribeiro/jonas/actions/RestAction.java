package rosa.ribeiro.jonas.actions;

import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.creatures.CreatureEngine;

public class RestAction implements Action {
    private ActionType actionType;
    private CreatureEngine creatureEngine;

    public RestAction(CreatureEngine creatureEngine) {

        this.actionType = ActionType.REST;
        this.creatureEngine = creatureEngine;
    }

    @Override
    public Coordinate getCoordinate() {
        return creatureEngine.getCreature().getPosition();
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
        creatureEngine.rest();
        System.out.println("\n " + creatureEngine.getCreature().getNickname() + " descansou na posição: " + getCoordinate());

    }
}
