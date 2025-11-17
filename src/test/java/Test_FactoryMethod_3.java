import edu.io.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

public class Test_FactoryMethod_3 {

    @Test
    void class_Token_is_abstract() {
       Assertions.assertTrue(Modifier.isAbstract(Token.class.getModifiers()));
    }

    @Test
    void GoldToken_has_amount() {
        var t = new GoldToken(5);
        Assertions.assertEquals(5, t.amount());
    }

    @Test
    void FoodToken_has_amount() {
        var t = new FoodToken(5);
        Assertions.assertEquals(5, t.amount());
    }

    @Test
    void ShovelToken_has_durability() {
        var t = new ShovelToken(5);
        Assertions.assertEquals(5, t.durability());
    }

    @Test
    void factory_can_create_empty_token() {
        Assertions.assertInstanceOf(
                EmptyToken.class,
                TokenFactory.createEmptyToken());
    }

    @Test
    void factory_can_create_gold_token() {
        Assertions.assertInstanceOf(
                GoldToken.class,
                TokenFactory.createGoldToken());
    }

    @Test
    void factory_can_create_food_token() {
        Assertions.assertInstanceOf(
                FoodToken.class,
                TokenFactory.createFoodToken());
    }

    @Test
    void factory_can_create_shovel_token() {
        Assertions.assertInstanceOf(
                ShovelToken.class,
                TokenFactory.createShovelToken());
    }

}