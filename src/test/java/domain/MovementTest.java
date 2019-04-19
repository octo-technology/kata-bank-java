package domain;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementTest {

    @Test
    public void shouldHaveAmountDirectionAndDate() {
        LocalDate date = LocalDate.of(2019, Month.OCTOBER, 15);
        Movement movement = new Movement(100, Direction.DEPOSIT, date);

        assertThat(movement.amount).isEqualTo(100);
        assertThat(movement.direction).isEqualTo(Direction.DEPOSIT);
        assertThat(movement.date).isEqualTo(date);
    }
}
