package paka4Q1;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    
    private Scanner input = new Scanner(System.in);
    private String gameMode;

    private String getGameMode() {
        return this.gameMode;
    }

    private void printRules() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("The board is a 3x3 grid.");
        System.out.println("Players take turns placing their symbol on the board.");
        System.out.println("The first player to get 3 of their symbols in a row wins!");
        System.out.println("The row can be horizontal, vertical, or diagonal.");
        System.out.println("Let's get started!");
        System.out.println();
    }

    private void setupGame() {
        this.gameMode = chooseGameMode();
        System.out.println("Game mode: " + this.getGameMode()); // FOR TESTING
        if (this.getGameMode().equals("PvP")) {
            this.player1 = new Player("X");
            this.player2 = new Player("O");
        } else if (this.getGameMode().equals("PvC")) {
            // TODO
        } else if (this.getGameMode().equals("CvC")) {
            // TODO
        }
    }

    private void setupBoard() {
        this.board = new Board();
        this.board.setEmptyBoard();
    }

    public void startGame() {
        do {
            printRules();
            setupGame();
            setupBoard();
            // TODO game loop
            gameLoop();

            String playAgain;
            do {
                System.out.print("Play again? (y/n): ");
                playAgain = input.nextLine();
            } while (!playAgain.equalsIgnoreCase("y") && !playAgain.equalsIgnoreCase("n"));
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            } else {
                System.out.println();
            }
        } while (true);
    }

    private void gameLoop() {
        while (!this.board.isBoardFull() && !this.board.hasWinner()) {
            board.placeSymbol(player1.chooseSpot(board), player1.getSymbol());
            if (this.board.hasWinner()) {
                System.out.println("Player " + player1.getSymbol() + " wins!");
                break;
            }

            board.placeSymbol(player2.chooseSpot(board), player2.getSymbol());
            if (this.board.hasWinner()) {
                System.out.println("Player " + player2.getSymbol() + " wins!");
                break;
            }
        }

        if (this.board.isBoardFull()) {
            System.out.println("It's a tie!");
        }
    }

    private String chooseGameMode() {
        do {
            System.out.println("Choose game mode: ");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Computer");
            System.out.println("3. Computer vs Computer");
            System.out.print("Enter choice: ");
            String choice = input.nextLine();

            if (choice.equals("1")) {
                return "PvP";
            } else if (choice.equals("2")) {
                return "PvC";
            } else if (choice.equals("3")) {
                return "CvC";
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } while (true);
    }
}