package paka4Q1;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Board board = new Board();
        board.setEmptyBoard();
        board.displayBoard();

        Game game = new Game();
        game.startGame();
    }
}
