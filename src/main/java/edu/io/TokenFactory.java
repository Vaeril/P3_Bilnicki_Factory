package edu.io;

public class TokenFactory {

    private static final int defaultGoldAmount = 5;
    private static final int defaultFoodAmount = 2;
    private static final float defaultShovelDurability = 10f;

    public static Token createEmptyToken() {
        return new EmptyToken();
    }

    public static Token createGoldToken() {
        return new GoldToken(defaultGoldAmount);
    }

    public static Token createFoodToken() {
        return new FoodToken(defaultFoodAmount);
    }

    public static Token createShovelToken() {
        return new ShovelToken(defaultShovelDurability);
    }

}
