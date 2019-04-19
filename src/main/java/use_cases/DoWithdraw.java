package use_cases;

import domain.Account;

import static java.time.LocalDate.now;

public class DoWithdraw {

    private Account account;

    public DoWithdraw(Account account) {
        this.account = account;
    }

    public void withdrawNow(int amount) {
        this.account.withdraw(amount, now());
    }
}
