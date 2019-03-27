import java.util.ArrayList;
import java.util.List;

public class Account {
    public int balance;
    public List report = new ArrayList();

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}
