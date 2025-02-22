import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Before
    public void setUp() {
         ingredient1 = new Ingredient(IngredientType.SAUCE, "Test Ingredient1", 15f);
         ingredient2 = new Ingredient(IngredientType.FILLING, "Test Ingredient2", 25f);
    }

    @Test
    public void checkReturnCorrectPrice() {
        assertEquals(15f, ingredient1.getPrice(), 0.00001);
        assertEquals(25f, ingredient2.getPrice(), 0.00001);
    }

    @Test
    public void checkReturnCorrectName() {
        assertEquals("Test Ingredient1", ingredient1.getName());
        assertEquals("Test Ingredient2", ingredient2.getName());
    }

    @Test
    public void checkReturnCorrectType() {
        assertEquals(IngredientType.SAUCE, ingredient1.getType());
        assertEquals(IngredientType.FILLING, ingredient2.getType());
    }
}
