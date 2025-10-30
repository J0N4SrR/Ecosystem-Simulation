package rosa.ribeiro.jonas.actions;


import rosa.ribeiro.jonas.resouces.Resource;
import rosa.ribeiro.jonas.resouces.ResourceType;
import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.creatures.LifeManager;

public class UseResourceAction implements Action{
    private Coordinate coordinate;
    private int priority;
    private ActionType actionType;
    private LifeManager lifeManager;
    private Resource resource;

    public UseResourceAction(Resource resource, LifeManager lifeManager) {
        this.coordinate = resource.getPosition();
        this.priority = lifeManager.priorityByResourceType(resource.getResourceType());
        this.actionType = ActionType.USE_RESOURCE;
        this.lifeManager = lifeManager;
        this.resource = resource;
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
            lifeManager.actionByResourceType(resource.getResourceType());
            System.out.println(lifeManager.getCreature().getNickname() + "  foi ao " + resource.getName() +" - Posição: " + getCoordinate());

        }
    }
}
