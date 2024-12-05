package paka4Q2;

import java.util.Scanner;

public class UpgradedGame extends Game {
    private Scanner input = new Scanner(System.in);
    public UpgradedGame() {
        super();
    }

    @Override
    public void setupBoard() {
        int boardSize = chooseBoardSize();
        this.setBoard(new Board(boardSize));
        this.getBoard().setEmptyBoard();
    }

    private int chooseBoardSize() {
        int size;
        while (true) {
            System.out.print("Enter board size (3 to 20): ");
            String inputSize = input.nextLine();
            try {
                size = Integer.parseInt(inputSize);
                if (size >= 3 && size <= 20) {
                    break;
                } else {
                    System.out.println("Invalid size. Please enter a number between 3 and 20.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return size;
    }
}