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

    public int[] chooseSpot(Board board) {
        int[] location = new int[2];
        String[] coordinates;
        while (true) {
            board.displayBoard();
            System.out.println("Player " + this.getSymbol() + ", choose a spot on the board.");
            System.out.println("Enter in the form 'row, column' where row and column are integers on the side of the board: ");
            try {
                coordinates = this.input.nextLine().split(",");
                if (coordinates.length != 2) {
                    throw new IllegalArgumentException("Invalid input. Please enter two integers separated by a comma.");
                }
                location[0] = Integer.parseInt(coordinates[0].trim()) - 1;
                location[1] = Integer.parseInt(coordinates[1].trim()) - 1;
                if (location[0] < 0 || location[0] >= board.getBoardSize() || location[1] < 0 || location[1] >= board.getBoardSize()) {
                    throw new IllegalArgumentException("Coordinates out of bounds. Please try again.");
                }
                if (!board.isSpotAvailable(location)) {
                    throw new IllegalArgumentException("Spot is not available. Please choose another spot.");
                }
                System.out.println();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid integers.");
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        return location;
    }
}