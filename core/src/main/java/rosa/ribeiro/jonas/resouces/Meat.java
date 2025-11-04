package rosa.ribeiro.jonas.resouces;

import rosa.ribeiro.jonas.world.Coordinate;

public class Meat implements Resource {
    private final String name;
    private final Coordinate position;
    private final ResourceType resourceType;
    private final int nutritionValue;
    private final int decayTime;

    public Meat(String name, Coordinate position, int nutritionValue, int decayTime) {
        this.name = name;
        this.position = position;
        this.resourceType = ResourceType.MEAT;
        this.nutritionValue = nutritionValue;
        this.decayTime = decayTime;
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
