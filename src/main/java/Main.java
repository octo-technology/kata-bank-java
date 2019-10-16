import domain.Account;
import domain.View;
import infrastructure.ConsoleView;
import infrastructure.UserInterface;
import use_cases.DoDeposit;
import use_cases.DoWithdraw;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(1000, LocalDate.of(2019, 3, 1));
        account.withdraw(150, LocalDate.of(2019, 3, 10));
        account.withdraw(100, LocalDate.of(2019, 3, 20));
        account.withdraw(20, LocalDate.of(2019, 3, 30));

        View consoleView = new ConsoleView();
        DoDeposit doDeposit = new DoDeposit(account);
        DoWithdraw doWithdraw = new DoWithdraw(account);
        UserInterface userInterface = new UserInterface(consoleView, doDeposit, doWithdraw);
        String action = userInterface.getAction();
        userInterface.callAction(action);
    }
}
