package paka4Q1;

public class Board {
    private String[][] board;

    public Board(int size) {
        this.board = new String[size][size];
    }

    public String[][] getBoard() {
        return this.board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public int getBoardSize() {
        return this.getBoard().length;
    }

    public void setEmptyBoard() {
        for (int row = 0; row < this.getBoardSize(); row++) {
            for (int column = 0; column < this.getBoardSize(); column++) {
                this.getBoard()[row][column] = " ";
            }
        }
    }

    public void displayBoard() {
        // Print column numbers
        System.out.print("   ");
        for (int row = 1; row <= this.getBoardSize(); row++) {
            System.out.print(" " + row + " ");
            if (row < this.getBoardSize()) {
                System.out.print("|");
            }
        }
        System.out.println();

        printLine(this.getBoardSize());

        // Print rows of board
        for (int row = 0; row < this.getBoardSize(); row++) {
            System.out.print((row + 1) + " | ");
            for (int column = 0; column < this.getBoardSize(); column++) {
                System.out.print(this.getBoard()[row][column]);
                System.out.print(" | ");
            }
            System.out.println();
            printLine(this.getBoardSize());
        }
    }

    // Helper method to print a line of the board
    private static void printLine(int size) {
        System.out.print("--+");
        for (int column = 0; column < size; column++) {
            System.out.print("---+");
        }
        System.out.println();
    }

    // Algorithm to check if there is a winner
    public boolean hasWinner() {
        // Check rows
        boolean winCheck = false;
        for (int row = 0; row < this.getBoardSize(); row++) {
            winCheck = true;
            String symbol = this.getBoard()[row][0];
            if (symbol.equals(" ")) {
                winCheck = false;
                continue;
            }
            for (int column = 1; column < this.getBoardSize(); column++) {
                if (!this.getBoard()[row][column].equals(symbol)) {
                    winCheck = false;
                    break;
                }
            }
            if (winCheck) {
                return winCheck;
            }
        }

        // Check columns
        for (int column = 0; column < this.getBoardSize(); column++) {
            winCheck = true;
            String symbol = this.getBoard()[0][column];
            if (symbol.equals(" ")) {
                winCheck = false;
                continue;
            }
            for (int row = 1; row < this.getBoardSize(); row++) {
                if (!this.getBoard()[row][column].equals(symbol)) {
                    winCheck = false;
                    break;
                }
            }
            if (winCheck) {
                return winCheck;
            }
        }

        // Check diagonals
        String symbol = this.getBoard()[0][0];
        if (!symbol.equals(" ")) {
            winCheck = true;
            for (int diagonal = 1; diagonal < this.getBoardSize(); diagonal++) {
                if (!this.getBoard()[diagonal][diagonal].equals(symbol)) {
                    winCheck = false;
                    break;
                }
            }
            if (winCheck) {
                return winCheck;
            }
        }
        symbol = this.getBoard()[0][this.getBoardSize() - 1];
        if (!symbol.equals(" ")) {
            winCheck = true;
            for (int diagonal = 1; diagonal < this.getBoardSize(); diagonal++) {
                if (!this.getBoard()[diagonal][this.getBoardSize() - 1 - diagonal].equals(symbol)) {
                    winCheck = false;
                    break;
                }
            }
            if (winCheck) {
                return winCheck;
            }
        }
        return false;
    }

    // Algorithm to check if the board is full
    public boolean isBoardFull() {
        for (int row = 0; row < this.getBoardSize(); row++) {
            for (int column = 0; column < this.getBoardSize(); column++) {
                if (this.getBoard()[row][column].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void placeSymbol(int[] location, String symbol) {
        this.getBoard()[location[0]][location[1]] = symbol;
    }

    public boolean isSpotAvailable(int[] location) {
        return this.getBoard()[location[0]][location[1]].equals(" ");
    }
}