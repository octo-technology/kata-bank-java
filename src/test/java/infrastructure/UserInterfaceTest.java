package infrastructure;

import domain.Account;
import domain.View;
import org.junit.Test;
import use_cases.DoDeposit;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class UserInterfaceTest {

    @Test
    public void getAction_should_display_select_action_text() {
        // Given
        View view = mock(View.class);

        UserInterface userInterface = new UserInterface(view, null);

        // When
        userInterface.getAction();

        // Then
        verify(view).display("Select action:\n" +
                "1) Make a deposit");
    }

    @Test
    public void getAction_should_return_deposit_when_action_is_1() {
        // Given
        View view = mock(View.class);
        UserInterface userInterface = new UserInterface(view, null);
        when(view.getUserInput()).thenReturn("1");

        // When
        String action = userInterface.getAction();

        // Then
        assertThat(action).isEqualTo("deposit");
    }

    @Test
    public void callAction_should_ask_userInput_with_correct_informations() {
        // Given
        View view = mock(View.class);
        Account account = new Account();
        DoDeposit doDeposit = new DoDeposit(account);
        UserInterface userInterface = new UserInterface(view, doDeposit);
        when(view.getUserInput()).thenReturn("1");

        // When
        userInterface.callAction("deposit");

        // Then
        verify(view).display("Give amount to deposit");
    }

    @Test
    public void callAction_should_call_given_action_with_userInput() {
        // Given
        View view = mock(View.class);
        Account account = new Account();
        DoDeposit doDeposit = new DoDeposit(account);
        UserInterface userInterface = new UserInterface(view, doDeposit);
        int depositedAmount = 100;
        when(view.getUserInput()).thenReturn(String.valueOf(depositedAmount));

        // When
        userInterface.callAction("deposit");

        // Then
        assertThat(account.balanceAt(now())).isEqualTo(depositedAmount);
    }
}