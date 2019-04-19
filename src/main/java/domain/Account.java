package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    int balance;
    List<Movement> report = new ArrayList<>();

    public void deposit(int amount, LocalDate date) {
        report.add(new Movement(amount, Direction.DEPOSIT, date));
        balance += amount;
    }

    public void withdraw(int amount, LocalDate date) {
        report.add(new Movement(amount, Direction.WITHDRAWAL, date));
        balance -= amount;
    }

    public int balanceAt(LocalDate date) {
        return report.stream()
                .filter(movement -> isBeforeOrEqual(movement, date))
                .mapToInt(Movement::signedAmount)
                .sum();
    }

    private boolean isBeforeOrEqual(Movement movement, LocalDate date) {
        return movement.date.isBefore(date) || movement.date.isEqual(date);
    }
}
