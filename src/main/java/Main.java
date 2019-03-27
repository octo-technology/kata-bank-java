import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(1000, LocalDate.of(2019, 3, 1));
        account.withdraw(150, LocalDate.of(2019, 3, 10));
        account.withdraw(100, LocalDate.of(2019, 3, 20));
        account.withdraw(20, LocalDate.of(2019, 3, 30));

        System.out.println(account);
    }
}
