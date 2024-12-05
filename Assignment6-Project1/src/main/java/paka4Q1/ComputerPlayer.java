package paka4Q1;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String symbol) {
        super(symbol);
    }

    @Override
    public int[] chooseSpot(Board board) {
        int[] location = new int[2];
        while (true) {
            location[0] = (int) (Math.random() * board.getBoardSize());
            location[1] = (int) (Math.random() * board.getBoardSize());
            if (board.isSpotAvailable(location)) {
                break;
            }
        }
        return location;
    }
}