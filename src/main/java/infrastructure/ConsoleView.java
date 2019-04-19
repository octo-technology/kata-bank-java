package infrastructure;

import domain.View;

import java.util.Scanner;

public class ConsoleView implements View {

    private final Scanner reader = new Scanner(System.in);

    @Override
    public void display(String textToDisplay) {
        System.out.println(textToDisplay);
    }

    @Override
    public String getUserInput() {
        return reader.next();
    }
}
