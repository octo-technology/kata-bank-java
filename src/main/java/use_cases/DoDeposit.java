package use_cases;

import domain.Account;

import static java.time.LocalDate.now;

public class DoDeposit {
    private Account account;

    public DoDeposit(Account account) {
        this.account = account;
    }

    public void depositNow(int amount) {
        account.deposit(amount, now());
    }
}
