package edu.io;

public class TokenFactory {

    private static final int defaultGoldAmount = 5;
    private static final int defaultFoodAmount = 2;
    private static final float defaultShovelDurability = 10f;
    private static final int tokenPoolSize = 10;

    private static TokenFactory tokenFactory = new TokenFactory();
    private final EmptyToken emptyTokenPool = new EmptyToken();
    private final GoldToken[] goldTokenPool = new GoldToken[tokenPoolSize];
    private final FoodToken[] foodTokenPool = new FoodToken[tokenPoolSize];

    private TokenFactory() {
        for (int i = 0; i < tokenPoolSize; i++) {
            goldTokenPool[i] = new GoldToken(i);
            foodTokenPool[i] = new FoodToken(i);
        }
    }

    public static EmptyToken createEmptyToken() {
        return tokenFactory.emptyTokenPool;
    }

    public static GoldToken createGoldToken() {
        return createGoldToken(defaultGoldAmount);
    }

    public static FoodToken createFoodToken() {
        return createFoodToken(defaultFoodAmount);
    }

    public static ShovelToken createShovelToken() {
        return createShovelToken(defaultShovelDurability);
    }

    public static GoldToken createGoldToken(int amount){
        if(amount >= tokenPoolSize || amount < 0)
            return null;
        return tokenFactory.goldTokenPool[amount];
    }

    public static FoodToken createFoodToken(int amount){
        if(amount >= tokenPoolSize || amount < 0)
            return null;
        return tokenFactory.foodTokenPool[amount];
    }

    public static ShovelToken createShovelToken(float durability){
        return new ShovelToken(durability);
    }
}
