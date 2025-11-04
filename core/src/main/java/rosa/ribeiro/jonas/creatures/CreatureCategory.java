package rosa.ribeiro.jonas.creatures;

public enum CreatureCategory {
    HUNTER("hunter"),
    PREY("prey"),
    SCAVENGER("scavenger"),
    NEUTRAL("neutral");

    private final String description;

    CreatureCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
