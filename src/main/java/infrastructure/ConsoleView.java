package infrastructure;

import domain.View;

import java.util.Scanner;

public class ConsoleView implements View {
    @Override
    public void display(String textToDisplay) {
        System.out.println(textToDisplay);
    }

    @Override
    public String getUserInput() {
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        reader.close();
        return input;
    }
}
