package edu.io;

public abstract class Token {
    public final String label;

    public Token(String label){
        this.label = label;
    }

    public String label() {  return label;   }
}
