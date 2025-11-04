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
        int basePriority = 10;
        int maxStamina = lifeManager.getCreature().getLifeStatus().getStaminaMax();
        int currentStamina = lifeManager.getCreature().getLifeStatus().getStamina();
        if (maxStamina > 0 && (currentStamina * 100 / maxStamina) > 90) {
            return basePriority + 5;
        }

        // A prioridade de passear é sempre baixa.
        return basePriority;
    }

    @Override
    public ActionType getActionType() {
        return actionType;
    }

    @Override
    public void execute() {
        if(lifeManager.getCreature().getPosition().equals(getCoordinate())){
            System.out.println(lifeManager.getCreature().getNickname() + " está cansado e não se moveu." + getCoordinate());
        } else {
            System.out.println(lifeManager.getCreature().getNickname() + " moveu-se para " + getCoordinate());
            lifeManager.move(getCoordinate());
        }
    }
}
