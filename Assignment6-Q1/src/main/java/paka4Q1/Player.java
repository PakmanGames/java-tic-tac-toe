package paka4Q1;

import java.util.Scanner;

public class Player {
    private String symbol;
    private Scanner input = new Scanner(System.in);

    public Player(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    // TODO player choose spot pass board as param
    public String chooseSpot(Board board) {
        String location;
        do {
            board.displayBoard();
            System.out.println("Choose an available spot on the board (Enter the number): ");
            location = input.nextLine();
            if (!board.isSpotAvailable(location)) {
                System.out.println("Spot is not available. Please choose another spot.");
                System.out.println("Enter one of the numbers you see on the board!");
            }
        } while (!board.isSpotAvailable(location));
        return location;
    }
}