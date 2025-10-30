package rosa.ribeiro.jonas.resouces;

import rosa.ribeiro.jonas.world.Coordinate;

public interface Resource {

    public Coordinate getPosition();
    public ResourceType getResourceType();
    public String getName();
    public int getDecayTime();
}
