import edu.io.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_FactoryMethod_5 {
    @Test
    void alternative_factory_can_create_empty_token() {
        Assertions.assertInstanceOf(
                EmptyToken.class,
                TokenFactoryAlternative.createToken(TokenFactoryAlternative.Type.EMPTY));
    }

    @Test
    void alternative_factory_can_create_gold_token() {
        Assertions.assertInstanceOf(
                GoldToken.class,
                TokenFactoryAlternative.createToken(TokenFactoryAlternative.Type.GOLD));
    }

    @Test
    void alternative_factory_can_create_food_token() {
        Assertions.assertInstanceOf(
                FoodToken.class,
                TokenFactoryAlternative.createToken(TokenFactoryAlternative.Type.FOOD));
    }

    @Test
    void alternative_factory_can_create_shovel_token() {
        Assertions.assertInstanceOf(
                ShovelToken.class,
                TokenFactoryAlternative.createToken(TokenFactoryAlternative.Type.SHOVEL));
    }

    @Test
    void alternative_factory_can_create_gold_token_with_value() {
        Token t = TokenFactoryAlternative.createToken(TokenFactoryAlternative.Type.GOLD, 3);
        Assertions.assertInstanceOf(
                GoldToken.class,
                t);
        Assertions.assertEquals(3, ((GoldToken) t).amount());
    }

    @Test
    void alternative_factory_can_create_food_token_with_value() {
        Token t = TokenFactoryAlternative.createToken(TokenFactoryAlternative.Type.FOOD, 5);
        Assertions.assertInstanceOf(
                FoodToken.class,
                t);
        Assertions.assertEquals(5, ((FoodToken) t).amount());
    }

    @Test
    void alternative_factory_can_create_shovel_token_with_value() {
        Token t = TokenFactoryAlternative.createToken(TokenFactoryAlternative.Type.SHOVEL, 4f);
        Assertions.assertInstanceOf(
                ShovelToken.class,
                t);
        Assertions.assertEquals(4, ((ShovelToken) t).durability());
    }

    @Test
    void alternative_factory_can_create_random_value_token() {
        Token t = TokenFactoryAlternative.createToken(TokenFactoryAlternative.Type.GOLD, TokenFactoryAlternative.randomAmount());
        Assertions.assertInstanceOf(
                GoldToken.class,
                t);
    }
}
