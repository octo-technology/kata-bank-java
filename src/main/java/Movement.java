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

    public int signedAmount() {
        return amount * (direction == Direction.DEPOSIT ? 1 : -1);
    }
}
