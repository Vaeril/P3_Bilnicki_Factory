package edu.io;

public final class ShovelToken extends Token {

    private final float durability;

    public ShovelToken(float durability){
        super("ShovelToken");
        this.durability = durability;
    }

    public float durability() { return durability; }
}
