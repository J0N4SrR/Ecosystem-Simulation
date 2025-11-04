package rosa.ribeiro.jonas.resouces;

import rosa.ribeiro.jonas.world.Coordinate;

public class Water implements Resource{
    private Coordinate position;
    private ResourceType resourceType;
    private String name = null;

    public Water(String name, Coordinate position) {
        this.name = name;
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDecayTime() {
        return 0;
    }
}
