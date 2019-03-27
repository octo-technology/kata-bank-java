import java.util.ArrayList;
import java.util.List;

class Account {
    int balance;
    List report = new ArrayList();

    void deposit(int amount) {
        report.add(amount);
        balance += amount;
    }

    void withdraw(int amount) {
        balance -= amount;
    }
}
