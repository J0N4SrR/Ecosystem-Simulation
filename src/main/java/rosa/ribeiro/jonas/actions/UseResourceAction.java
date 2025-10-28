package rosa.ribeiro.jonas.actions;


import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.creatures.CreatureEngine;

public class UseResourceAction implements Action{
    private Coordinate coordinate;
    private int priority;
    private ActionType actionType;
    private CreatureEngine creatureEngine;

    public UseResourceAction(Coordinate resourceCoordinate, int priority, CreatureEngine creatureEngine) {
        this.coordinate = resourceCoordinate;
        this.priority = priority;
        this.actionType = ActionType.USE_RESOURCE;
        this.creatureEngine = creatureEngine;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public int getActionPriority() {
        return priority;
    }

    @Override
    public ActionType getActionType() {
        return actionType;
    }

    @Override
    public void execute() {
        if(creatureEngine.move(coordinate)){
            creatureEngine.drinkWater();
            System.out.println("\n" + creatureEngine.getCreature().getNickname() + "  Foi beber agua na posição: " + getCoordinate());

        }
    }
}
