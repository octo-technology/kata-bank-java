package infrastructure;

import domain.Account;
import domain.View;
import org.junit.Test;
import use_cases.DoDeposit;
import use_cases.DoWithdraw;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class UserInterfaceTest {

    @Test
    public void getAction_should_display_select_action_text() {
        // Given
        View view = mock(View.class);
        when(view.getUserInput()).thenReturn("0");
        UserInterface userInterface = new UserInterface(view, null, null);

        // When
        userInterface.getAction();

        // Then
        verify(view).display("Select action:\n" +
                "1) Make a deposit\n" +
                "2) Make a withdrawal");
    }

    @Test
    public void getAction_should_return_deposit_when_action_is_1() {
        // Given
        View view = mock(View.class);
        UserInterface userInterface = new UserInterface(view, null, null);
        when(view.getUserInput()).thenReturn("1");

        // When
        String action = userInterface.getAction();

        // Then
        assertThat(action).isEqualTo("deposit");
    }

    @Test
    public void getAction_should_return_withdraw_when_action_is_2() {
        // Given
        View view = mock(View.class);
        UserInterface userInterface = new UserInterface(view, null, null);
        when(view.getUserInput()).thenReturn("2");

        // When
        String action = userInterface.getAction();

        // Then
        assertThat(action).isEqualTo("withdraw");
    }

    @Test
    public void callAction_should_ask_userInput_with_correct_display_for_deposit() {
        // Given
        View view = mock(View.class);
        Account account = new Account();
        DoDeposit doDeposit = new DoDeposit(account);
        UserInterface userInterface = new UserInterface(view, doDeposit, null);
        when(view.getUserInput()).thenReturn("100");

        // When
        userInterface.callAction("deposit");

        // Then
        verify(view).display("Give amount to deposit");
    }

    @Test
    public void callAction_should_ask_userInput_with_correct_display_for_withdraw() {
        // Given
        View view = mock(View.class);
        Account account = new Account();
        DoWithdraw doWithdraw = new DoWithdraw(account);
        UserInterface userInterface = new UserInterface(view, null, doWithdraw);
        when(view.getUserInput()).thenReturn("100");

        // When
        userInterface.callAction("withdraw");

        // Then
        verify(view).display("Give amount to withdraw");
    }

    @Test
    public void callAction_should_call_given_action_with_userInput_for_deposit() {
        // Given
        View view = mock(View.class);
        Account account = new Account();
        DoDeposit doDeposit = new DoDeposit(account);
        UserInterface userInterface = new UserInterface(view, doDeposit, null);
        int depositedAmount = 100;
        when(view.getUserInput()).thenReturn(String.valueOf(depositedAmount));

        // When
        userInterface.callAction("deposit");

        // Then
        assertThat(account.balanceAt(now())).isEqualTo(depositedAmount);
    }

    @Test
    public void callAction_should_call_given_action_with_userInput_for_withdraw() {
        // Given
        View view = mock(View.class);
        Account account = new Account();
        DoWithdraw doWithdraw = new DoWithdraw(account);
        UserInterface userInterface = new UserInterface(view, null, doWithdraw);
        int withdrawdAmount = 100;
        when(view.getUserInput()).thenReturn(String.valueOf(withdrawdAmount));

        // When
        userInterface.callAction("withdraw");

        // Then
        assertThat(account.balanceAt(now())).isEqualTo(-withdrawdAmount);
    }
}