package rosa.ribeiro.jonas;


public class UseResourceAction implements Action{
    private Coordinate coordinate;
    private int priority;
    private ActionType actionType;
    private CreatureEngine creatureEngine;

    public UseResourceAction(Coordinate coordinate, int priority, CreatureEngine creatureEngine) {
        this.coordinate = coordinate;
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
        }
    }
}
