package edu.io;

import java.util.Random;

public class TokenFactoryAlternative {

    private static final int defaultGoldAmount = 5;
    private static final int defaultFoodAmount = 2;
    private static final float defaultShovelDurability = 10f;
    private static final int tokenPoolSize = 10;

    private static TokenFactoryAlternative tokenFactory = new TokenFactoryAlternative();
    private final EmptyToken emptyTokenPool = new EmptyToken();
    private final GoldToken[] goldTokenPool = new GoldToken[tokenPoolSize];
    private final FoodToken[] foodTokenPool = new FoodToken[tokenPoolSize];

    private TokenFactoryAlternative() {
        for (int i = 0; i < tokenPoolSize; i++) {
            goldTokenPool[i] = new GoldToken(i);
            foodTokenPool[i] = new FoodToken(i);
        }
    }

    public static Token createToken(Type type){
        return switch (type) {
            case GOLD -> createToken(type, defaultGoldAmount);
            case FOOD -> createToken(type, defaultFoodAmount);
            case EMPTY -> createToken(type, 0);
            case SHOVEL -> createToken(type, defaultShovelDurability);
        };
    }

    public static Token createToken(Type type, int amount){
        if(amount >= tokenPoolSize || amount < 0)
            return null;

        return switch (type) {
            case GOLD -> tokenFactory.goldTokenPool[amount];
            case FOOD -> tokenFactory.foodTokenPool[amount];
            case EMPTY -> tokenFactory.emptyTokenPool;
            default -> null;
        };
    }

    public static Token createToken(Type type, float durability){
        return new ShovelToken(durability);
    }

    public static int randomAmount() {
        Random rand = new Random();
        return rand.nextInt(0, tokenPoolSize);
    }

    public static enum Type {GOLD, FOOD, SHOVEL, EMPTY}
}
