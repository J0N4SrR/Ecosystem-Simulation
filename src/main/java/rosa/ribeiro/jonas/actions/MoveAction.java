package rosa.ribeiro.jonas.actions;

import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.creatures.LifeManager;

public class MoveAction implements Action{
    private Coordinate coordinate;
    private ActionType actionType;
    private LifeManager lifeManager;


    public MoveAction(LifeManager lifeManager) {
        this.actionType = ActionType.MOVE;
        this.lifeManager = lifeManager;
        this.coordinate = lifeManager.wander();

    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
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
        if(lifeManager.getCreature().getLifeManager().getPosition().equals(getCoordinate())){
            System.out.println("\n " + lifeManager.getCreature().getNickname() + " está cansado e não se moveu." + getCoordinate());
        } else {
            System.out.println("\n " + lifeManager.getCreature().getNickname() + " moveu-se para " + getCoordinate());
            lifeManager.move(getCoordinate());
        }
    }
}
