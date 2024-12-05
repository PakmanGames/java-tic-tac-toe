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

    // Print the rules of the game
    private void printRules() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("The board is a 3x3 grid.");
        System.out.println("Players take turns placing their symbol on the board.");
        System.out.println("The first player to get 3 of their symbols in a row wins!");
        System.out.println("The row can be horizontal, vertical, or diagonal.");
        System.out.println("Let's get started!");
        System.out.println();
    }

    // Setup the game mode of the game
    private void setupGame() {
        this.gameMode = chooseGameMode();
        System.out.println("Game mode: " + this.getGameMode());
        if (this.getGameMode().equals("PvP")) {
            this.player1 = new HumanPlayer("X");
            this.player2 = new HumanPlayer("O");
        } else if (this.getGameMode().equals("PvC")) {
            this.player1 = new HumanPlayer("X");
            this.player2 = new ComputerPlayer("O");
        } else if (this.getGameMode().equals("CvC")) {
            this.player1 = new ComputerPlayer("X");
            this.player2 = new ComputerPlayer("O");
        }
    }

    // Setup the board of the game
    private void setupBoard() {
        this.board = new Board(3);
        this.board.setEmptyBoard();
    }

    // Start the game
    public void startGame() {
        do {
            // Basic game setup
            printRules();
            setupGame();
            setupBoard();
            gameLoop();

            // Ask if the player wants to play again
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

    // Main game loop
    private void gameLoop() {
        while (!this.board.isBoardFull() && !this.board.hasWinner()) {
            if (takeTurn(player1)) {
                return;
            }
            if (takeTurn(player2)) {
                return;
            }
        }
    }

    // Take a turn for a player
    private boolean takeTurn(Player player) {
        board.placeSymbol(player.chooseSpot(board), player.getSymbol());
        if (this.board.hasWinner()) {
            board.displayBoard();
            System.out.println("Player " + player.getSymbol() + " wins!");
            return true;
        }

        if (this.board.isBoardFull()) {
            board.displayBoard();
            System.out.println("It's a tie!");
            return true;
        }

        return false;
    }

    // Choose the game mode
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