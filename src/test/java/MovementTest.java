import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementTest {

    @Test
    public void shouldHaveAmountDirectionAndDate() {
        Movement movement = new Movement(100, "DEPOSIT", "2018-02-15");

        assertThat(movement.amount).isEqualTo(100);
        assertThat(movement.direction).isEqualTo("DEPOSIT");
        assertThat(movement.date).isEqualTo("2018-02-15");
    }
}
