package paka4Q1;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    
    private Scanner input = new Scanner(System.in);
    private String gameMode;

    // TODO change constructor
    public Game() {
        this.player1 = new Player("X");
        this.player2 = new Player("O");
        this.board = new Board();
        this.board.setEmptyBoard();

        // TODO print welcome and rules

        // TODO pick game mode
        this.gameMode = chooseGameMode();
        System.out.println("Game mode: " + this.gameMode); // FOR TESTING

        // TODO PLAYER SETUP BASED ON GAMEMODE
    }

    // TODO game loop

    // TODO check board for winner / game over
    // check is full or has winner

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