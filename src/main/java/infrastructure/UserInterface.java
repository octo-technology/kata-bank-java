package infrastructure;

import domain.View;
import use_cases.DoDeposit;
import use_cases.DoWithdraw;

import static java.lang.Integer.parseInt;

public class UserInterface {

    private final View view;
    private final DoDeposit doDeposit;
    private final DoWithdraw doWithdraw;

    public UserInterface(View view, DoDeposit doDeposit, DoWithdraw doWithdraw) {
        this.view = view;
        this.doDeposit = doDeposit;
        this.doWithdraw = doWithdraw;
    }

    public String getAction() {
        view.display("Select action:\n" +
                "1) Make a deposit\n" +
                "2) Make a withdrawal");
        String userInput = view.getUserInput();

        String action = null;

        if (userInput.equals("1")) {
            action = "deposit";
        } else if (userInput.equals("2")) {
            action = "withdraw";
        }
        return action;
    }

    public void callAction(String action) {
        if (action.equals("deposit")) {
            view.display("Give amount to deposit");
            String userInput = view.getUserInput();
            doDeposit.depositNow(parseInt(userInput));
        } else if (action.equals("withdraw")) {
            view.display("Give amount to withdraw");
            String userInput = view.getUserInput();
            doWithdraw.withdrawNow(parseInt(userInput));
        }
    }
}
