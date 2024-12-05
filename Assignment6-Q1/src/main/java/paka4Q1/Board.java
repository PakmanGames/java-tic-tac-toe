package paka4Q1;

public class Board {
    private String[][] board;

    public Board() {
        this.board = new String[3][3];
    }

    public String[][] getBoard() {
        return this.board;
    }

    public int getBoardSize() {
        return this.getBoard().length;
    }

    public void setEmptyBoard() {
        for (int i = 0; i < this.getBoardSize(); i++) {
            for (int j = 0; j < this.getBoardSize(); j++) {
                this.getBoard()[i][j] = " ";
            }
        }
    }

    // FOR TESTING METHOD
    public void setBoard() {
        this.placeSymbol(new int[]{0, 0}, "X");
        this.placeSymbol(new int[]{0, 1}, "O");
        this.placeSymbol(new int[]{0, 2}, "X");
        this.placeSymbol(new int[]{1, 0}, "O");
        this.placeSymbol(new int[]{1, 1}, "X");
        this.placeSymbol(new int[]{1, 2}, "O");
        this.placeSymbol(new int[]{2, 0}, "X");
        this.placeSymbol(new int[]{2, 1}, "O");
        this.placeSymbol(new int[]{2, 2}, "X");
    }

    public void displayBoard() {
        for (int i = 0; i < this.getBoardSize(); i++) {
            for (int j = 0; j < this.getBoardSize(); j++) {
                System.out.print(" " + this.getBoard()[i][j]);
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

    public boolean hasWinner() {
        // Check rows
        for (int i = 0; i < this.getBoardSize(); i++) {
            String symbol = this.getBoard()[i][0];
            if (symbol.equals(" ")) {
                continue;
            }
            for (int j = 1; j < this.getBoardSize(); j++) {
                if (!this.getBoard()[i][j].equals(symbol)) {
                    break;
                }
                if (j == this.getBoardSize() - 1) {
                    return true;
                }
            }
        }

        // Check columns
        for (int i = 0; i < this.getBoardSize(); i++) {
            String symbol = this.getBoard()[0][i];
            if (symbol.equals(" ")) {
                continue;
            }
            for (int j = 1; j < this.getBoardSize(); j++) {
                if (!this.getBoard()[j][i].equals(symbol)) {
                    break;
                }
                if (j == this.getBoardSize() - 1) {
                    return true;
                }
            }
        }

        // Check diagonals
        String symbol = this.getBoard()[0][0];
        if (!symbol.equals(" ")) {
            for (int i = 1; i < this.getBoardSize(); i++) {
                if (!this.getBoard()[i][i].equals(symbol)) {
                    break;
                }
                if (i == this.getBoardSize() - 1) {
                    return true;
                }
            }
            for (int i = 1; i < this.getBoardSize(); i++) {
                if (!this.getBoard()[i][this.getBoardSize() - 1 - i].equals(symbol)) {
                    break;
                }
                if (i == this.getBoardSize() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // TODO check if board is full
    public boolean isBoardFull() {
        for (int i = 0; i < this.getBoardSize(); i++) {
            for (int j = 0; j < this.getBoardSize(); j++) {
                if (this.getBoard()[i][j].equals("X") || this.getBoard()[i][j].equals("O")) {
                    continue;
                } else {
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