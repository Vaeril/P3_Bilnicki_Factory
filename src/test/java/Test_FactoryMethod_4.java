import edu.io.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

public class Test_FactoryMethod_4 {

    @Test
    void factory_can_create_gold_token_with_amount() {
        GoldToken t = TokenFactory.createGoldToken(5);
        Assertions.assertEquals(5, t.amount());
        t = TokenFactory.createGoldToken(2);
        Assertions.assertEquals(2, t.amount());
    }

    @Test
    void factory_can_create_food_token_with_amount() {
        FoodToken t = TokenFactory.createFoodToken(7);
        Assertions.assertEquals(7, t.amount());
        t = TokenFactory.createFoodToken(9);
        Assertions.assertEquals(9, t.amount());
    }

    @Test
    void factory_can_create_shovel_token_with_durability() {
        ShovelToken t = TokenFactory.createShovelToken(10);
        Assertions.assertEquals(10, t.durability());
        t = TokenFactory.createShovelToken(99);
        Assertions.assertEquals(99, t.durability());
    }

    @Test
    void factory_can_create_one_empty_token() {
        Token t1 = TokenFactory.createEmptyToken();
        Token t2 = TokenFactory.createEmptyToken();
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void factory_has_gold_token_pool() {
        Token t1 = TokenFactory.createGoldToken(5);
        Token t2 = TokenFactory.createGoldToken(5);
        Assertions.assertEquals(t1, t2);
        t1 = TokenFactory.createGoldToken(10);
        t2 = TokenFactory.createGoldToken(3);
        Assertions.assertNotEquals(t1, t2);
    }

    @Test
    void factory_has_food_token_pool() {
        Token t1 = TokenFactory.createFoodToken(5);
        Token t2 = TokenFactory.createFoodToken(5);
        Assertions.assertEquals(t1, t2);
        t1 = TokenFactory.createFoodToken(10);
        t2 = TokenFactory.createFoodToken(3);
        Assertions.assertNotEquals(t1, t2);
    }

    @Test
    void factory_has_not_shovel_token_pool() {
        Token t1 = TokenFactory.createShovelToken(5);
        Token t2 = TokenFactory.createShovelToken(5);
        Assertions.assertNotEquals(t1, t2);
    }
}
