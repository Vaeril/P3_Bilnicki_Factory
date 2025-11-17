package edu.io;

public final class FoodToken extends Token {

    private final int amount;

    public FoodToken(int amount){
        super("FoodToken");
        this.amount = amount;
    }

    public int amount() { return amount; }
}
