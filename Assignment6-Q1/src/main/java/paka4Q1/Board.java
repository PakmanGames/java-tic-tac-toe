package paka4Q1;

public class Board {
    private String[][] board;

    public Board() {
        this.board = new String[3][3];
    }

    public int getBoardSize() {
        return this.board.length;
    }

    public void setEmptyBoard() {
        for (int i = 0; i < this.getBoardSize(); i++) {
            for (int j = 0; j < this.getBoardSize(); j++) {
                this.board[i][j] = " ";
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < this.getBoardSize(); i++) {
            for (int j = 0; j < this.getBoardSize(); j++) {
                System.out.print(" " + this.board[i][j]);
                if (j < this.getBoardSize() - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i < this.getBoardSize() - 1) {
                System.out.println("---+---+---");
            }
        }
    }

    // TODO loop through to check if winner

    // TODO check if board is full

    // TODO place symbol on board
}