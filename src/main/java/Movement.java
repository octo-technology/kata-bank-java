import java.time.LocalDate;

class Movement {

    int amount;
    Direction direction;
    LocalDate date;

    Movement(int amount, Direction direction, LocalDate date) {
        this.amount = amount;
        this.direction = direction;
        this.date = date;
    }

    enum Direction {
        DEPOSIT,
    }
}
