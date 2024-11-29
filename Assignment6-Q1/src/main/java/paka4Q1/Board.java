package paka4Q1;

public class Board {
    private String[][] board;

    public Board() {
        this.board = new String[3][3];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = " ";
            }
        }
    }
}