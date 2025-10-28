package rosa.ribeiro.jonas.actions;


import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.creatures.LifeManager;

public class DrinkAction implements Action{
    private Coordinate coordinate;
    private int priority;
    private ActionType actionType;
    private LifeManager lifeManager;

    public DrinkAction(Coordinate resourceCoordinate, int priority, LifeManager lifeManager) {
        this.coordinate = resourceCoordinate;
        this.priority = priority;
        this.actionType = ActionType.USE_RESOURCE;
        this.lifeManager = lifeManager;
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
        if(lifeManager.move(coordinate)){
            lifeManager.drinkWater();
            System.out.println("\n" + lifeManager.getCreature().getNickname() + "  Foi beber agua na posição: " + getCoordinate());

        }
    }
}
