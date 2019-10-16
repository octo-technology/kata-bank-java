package infrastructure;

import domain.AccountAction;
import domain.View;
import use_cases.DoDeposit;
import use_cases.DoWithdraw;

import static domain.AccountAction.DEPOSIT;
import static domain.AccountAction.WITHDRAWAL;
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
        String textToDisplay = "Select action:\n";
        for (AccountAction action : AccountAction.values()) {
            textToDisplay += action.getActionTextDescription() + '\n';
        }

        view.display(textToDisplay);
        String userInput = view.getUserInput();

        String action = null;

        if (userInput.equals(DEPOSIT.getActionNumber())) {
            action = DEPOSIT.getAction();
        } else if (userInput.equals(WITHDRAWAL.getActionNumber())) {
            action = WITHDRAWAL.getAction();
        }
        return action;
    }

    public void callAction(String action) {
        if (action.equals(DEPOSIT.getAction())) {
            view.display(DEPOSIT.getActionTextInput());
            String userInput = view.getUserInput();
            doDeposit.depositNow(parseInt(userInput));
        } else if (action.equals(WITHDRAWAL.getAction())) {
            view.display(WITHDRAWAL.getActionTextInput());
            String userInput = view.getUserInput();
            doWithdraw.withdrawNow(parseInt(userInput));
        }
    }
}
