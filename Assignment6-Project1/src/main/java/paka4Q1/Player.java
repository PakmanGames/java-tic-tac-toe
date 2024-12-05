package paka4Q1;

import java.util.Scanner;

public abstract class Player {
    private String symbol;
    private Scanner input = new Scanner(System.in);

    public Player(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public abstract int[] chooseSpot(Board board);
}