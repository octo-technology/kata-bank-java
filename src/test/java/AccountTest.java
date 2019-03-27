import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void shouldHaveBalanceOfZeroAtCreation() {
        Account account = new Account();

        assertThat(account.balance).isEqualTo(0);
    }

    @Test
    public void shouldIncreaseBalanceAfterDeposit() {
        Account account = new Account();

        depositToday(account, 5);

        assertThat(account.balance).isEqualTo(5);

        depositToday(account, 7);

        assertThat(account.balance).isEqualTo(12);
    }

    @Test
    public void shouldDecreaseBalanceAfterWithdrawal() {
        Account account = new Account();
        depositToday(account, 100);

        withdrawToday(account, 5);

        assertThat(account.balance).isEqualTo(95);

        withdrawToday(account, 7);

        assertThat(account.balance).isEqualTo(88);
    }

    @Test
    public void shouldProduceReportWithDeposit() {
        Account account = new Account();

        assertThat(account.report).isEmpty();

        int depositAmount = 100;
        LocalDate depositDate = LocalDate.of(2019, 03, 27);
        account.deposit(depositAmount, depositDate);

        assertThat(account.report).hasSize(1);
        Movement firstMovement = account.report.get(0);
        assertThat(firstMovement.amount).isEqualTo(depositAmount);
        assertThat(firstMovement.direction).isEqualTo(Direction.DEPOSIT);
        assertThat(firstMovement.date).isEqualTo(depositDate);
    }

    @Test
    public void shouldProduceReportWithDepositAndWithdrawal() {
        Account account = new Account();
        account.deposit(100, LocalDate.of(2019, 03, 27));

        int withdrawalAmount = 50;
        LocalDate withdrawalDate = LocalDate.of(2019, 03, 28);
        account.withdraw(withdrawalAmount, withdrawalDate);

        assertThat(account.report).hasSize(2);
        Movement secondMovement = account.report.get(1);
        assertThat(secondMovement.amount).isEqualTo(withdrawalAmount);
        assertThat(secondMovement.direction).isEqualTo(Direction.WITHDRAWAL);
        assertThat(secondMovement.date).isEqualTo(withdrawalDate);
    }

    private void depositToday(Account account, int amount) {
        account.deposit(amount, LocalDate.now());
    }

    private void withdrawToday(Account account, int amount) {
        account.withdraw(amount, LocalDate.now());
    }
}
