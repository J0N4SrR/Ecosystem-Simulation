package rosa.ribeiro.jonas.resouces;

public enum ResourceType {

    WATER("water");

    private String description;

    ResourceType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

