package use_cases;

import domain.Account;
import org.junit.Test;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;

public class DoWithdrawTest {

    @Test
    public void should_withdraw_now_with_given_amount() {
        // Given
        Account account = new Account();
        DoWithdraw doWithdraw = new DoWithdraw(account);

        // When
        doWithdraw.withdrawNow(10);

        // Then
        assertThat(account.balanceAt(now())).isEqualTo(-10);
    }
}