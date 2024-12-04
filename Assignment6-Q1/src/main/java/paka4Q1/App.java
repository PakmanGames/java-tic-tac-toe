package paka4Q1;

public class App {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();

        // FOR TESTING
        Board board = new Board();
        board.setEmptyBoard();
        board.displayBoard();
        board.setBoard();
        board.displayBoard();
        System.out.println(board.isBoardFull());
        System.out.println(board.hasWinner());
    }
}
