package rosa.ribeiro.jonas.actions;

import rosa.ribeiro.jonas.creatures.LifeManager;
import rosa.ribeiro.jonas.world.Coordinate;

import java.util.List;

public class HuntAction implements Action{
    private ActionType actionType;
    private LifeManager lifeManager;
    private LifeManager target;

    public HuntAction(LifeManager lifeManager, LifeManager target) {
        this.actionType = ActionType.HUNT;
        this.lifeManager = lifeManager;
        this.target = target;
    }

    @Override
    public Coordinate getCoordinate() {
        if (target != null) {
            return target.getCreature().getPosition();
        }
        return lifeManager.getCreature().getPosition();    }

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

        if (target == null || !target.isAlive()) {
            System.out.println(lifeManager.getCreature().getNickname() + " tentou caçar, mas o alvo não era válido.");
            return;
        }

        if(lifeManager.hasEnergy(target.getCreature().getPosition())){
            lifeManager.move(target.getCreature().getPosition());
            System.out.println(lifeManager.getCreature().getNickname() + " ABATEU " + target.getCreature().getNickname());
            target.getCreature().getLifeStatus().setHp(0);
        } else {
            System.out.println(lifeManager.getCreature().getNickname() + " não tem energia para caçar " + target.getCreature().getNickname());
        }

    }
}
