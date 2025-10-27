package rosa.ribeiro.jonas.actions;

public enum ActionType {

    USE_RESOURCE("use resource");

    private String description;

    ActionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
