package rosa.ribeiro.jonas.resouces;

import rosa.ribeiro.jonas.world.Coordinate;

public class Water implements Resource{
    private Coordinate position;
    private ResourceType resourceType;

    public Water(Coordinate position) {
        this.position = position;
        this.resourceType = ResourceType.WATER;
    }

    @Override
    public Coordinate getPosition() {
        return position;
    }

    @Override
    public ResourceType getResourceType() {
        return resourceType;
    }
}
