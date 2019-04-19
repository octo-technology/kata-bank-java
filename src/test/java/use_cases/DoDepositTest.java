package use_cases;

import domain.Account;
import org.junit.Test;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;

public class DoDepositTest {

    @Test
    public void should_do_deposit_now_with_given_amount() {
        // Given
        Account account = new Account();
        DoDeposit doDeposit = new DoDeposit(account);
        int depositAmount = 100;

        // When
        doDeposit.depositNow(depositAmount);

        // Then
        assertThat(account.balanceAt(now())).isEqualTo(depositAmount);
    }
}
