import domain.Account;
import domain.View;
import infrastructure.ConsoleView;
import infrastructure.UserInterface;
import use_cases.DoDeposit;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(1000, LocalDate.of(2019, 3, 1));
        account.withdraw(150, LocalDate.of(2019, 3, 10));
        account.withdraw(100, LocalDate.of(2019, 3, 20));
        account.withdraw(20, LocalDate.of(2019, 3, 30));

        System.out.println(account.balanceAt(now()));

        View consoleView = new ConsoleView();
        DoDeposit doDeposit = new DoDeposit(account);
        UserInterface userInterface = new UserInterface(consoleView, doDeposit);
        String action = userInterface.getAction();
        userInterface.callAction(action);

        System.out.println(account.balanceAt(now()));
    }
}
