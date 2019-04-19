package infrastructure;

import domain.View;
import use_cases.DoDeposit;

import static java.lang.Integer.parseInt;

public class UserInterface {

    private final View view;
    private final DoDeposit doDeposit;

    public UserInterface(View view, DoDeposit doDeposit) {
        this.view = view;
        this.doDeposit = doDeposit;
    }

    public String getAction() {
        view.display("Select action:\n" +
                "1) Make a deposit");
        return "deposit";
    }

    public void callAction(String action) {
        view.display("Give amount to deposit");
        String userInput = view.getUserInput();
        doDeposit.depositNow(parseInt(userInput));
    }
}
