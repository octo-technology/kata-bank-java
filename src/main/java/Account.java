import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Account {
    int balance;
    List<Movement> report = new ArrayList();

    void deposit(int amount, LocalDate date) {
        report.add(new Movement(amount, Direction.DEPOSIT, date));
        balance += amount;
    }

    void withdraw(int amount, LocalDate date) {
        report.add(new Movement(amount, Direction.WITHDRAWAL, date));
        balance -= amount;
    }
}
