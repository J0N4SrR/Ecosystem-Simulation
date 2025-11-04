package rosa.ribeiro.jonas.actions;

public enum ActionType {

    USE_RESOURCE("use resource"),
    MOVE("move"),
    REST("rest"),
    HUNT("hunt"),
    WAIT("wait");

    private final String description;

    ActionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
