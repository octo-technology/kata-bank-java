class Movement {

    int amount;
    Direction direction;
    String date;

    Movement(int amount, Direction direction, String date) {
        this.amount = amount;
        this.direction = direction;
        this.date = date;
    }

    enum Direction {
        DEPOSIT,
        WITHDRAWAL
    }
}
