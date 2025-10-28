package rosa.ribeiro.jonas.resouces;

import rosa.ribeiro.jonas.world.Coordinate;

public class Plant implements Resource{
    private Coordinate position;
    private ResourceType resourceType;

    public Plant(Coordinate position) {
        this.position = position;
        this.resourceType =ResourceType.PLANT;
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
