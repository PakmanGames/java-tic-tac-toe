package paka4Q2;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String symbol) {
        super(symbol);
    }

    @Override
    public int[] chooseSpot(Board board) {
        int[] location = new int[2];
        // Loop until a random available spot is chosen
        while (true) {
            board.displayBoard();
            location[0] = (int) (Math.random() * board.getBoardSize());
            location[1] = (int) (Math.random() * board.getBoardSize());
            // If spot is available
            if (board.isSpotAvailable(location)) {
                break;
            }
        }
        return location;
    }
}