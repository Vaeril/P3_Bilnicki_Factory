package edu.io;

public final class GoldToken extends Token {

    private final int amount;

    public GoldToken(int amount){
        super("GoldToken");
        this.amount = amount;
    }

    public int amount() { return amount; }
}
