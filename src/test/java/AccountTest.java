import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    @Test
    public void shouldHaveBalanceOfZeroAtCreation() {
        Account account = new Account();

        assertThat(account.balance).isEqualTo(0);
    }

    @Test
    public void shouldIncreaseBalanceAfterDeposit() {
        Account account = new Account();

        account.deposit(5);

        assertThat(account.balance).isEqualTo(5);

        account.deposit(7);

        assertThat(account.balance).isEqualTo(12);
    }

    @Test
    public void shouldDecreaseBalanceAfterWithdrawal() {
        Account account = new Account();
        account.deposit(100);

        account.withdraw(5);

        assertThat(account.balance).isEqualTo(95);

        account.withdraw(7);

        assertThat(account.balance).isEqualTo(88);
    }
}
