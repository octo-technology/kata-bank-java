package domain;

public enum AccountAction {
    DEPOSIT("deposit", "Give amount to deposit", "1", "1) Make a deposit"),
    WITHDRAWAL("withdraw", "Give amount to withdraw", "2", "2) Make a withdrawal");

    private final String action;
    private final String actionTextInput;
    private final String actionNumber;
    private final String actionTextDescription;

    AccountAction(String action, String actionTextInput, String actionNumber, String actionTextDescription) {
        this.action = action;
        this.actionTextInput = actionTextInput;
        this.actionNumber = actionNumber;
        this.actionTextDescription = actionTextDescription;
    }

    public String getAction() {
        return action;
    }

    public String getActionTextInput() {
        return actionTextInput;
    }

    public String getActionNumber() {
        return actionNumber;
    }

    public String getActionTextDescription() {
        return actionTextDescription;
    }
}
