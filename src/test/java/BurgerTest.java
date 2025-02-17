import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import org.mockito.Mock;
import static org.junit.Assert.*;;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockIngredient1;

    @Mock
    Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        when(mockBun.getName()).thenReturn("Test Bun");
        when(mockBun.getPrice()).thenReturn(100f);

        when(mockIngredient1.getName()).thenReturn("Test Ingredient1");
        when(mockIngredient1.getPrice()).thenReturn(50f);
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        when(mockIngredient2.getName()).thenReturn("Test Ingredient2");
        when(mockIngredient2.getPrice()).thenReturn(25f);
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Test
    public void checkSetBunForBurger() {
        burger.setBuns(mockBun);
        assertEquals("Test Bun", burger.bun.getName());
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals("Test Ingredient1", burger.ingredients.get(0).getName());
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals("Test Ingredient2", burger.ingredients.get(0).getName());
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Test Ingredient2", burger.ingredients.get(0).getName());
        assertEquals("Test Ingredient1", burger.ingredients.get(1).getName());
    }

    @Test
    public void checkGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        assertEquals(275f, burger.getPrice(), 0.001);
    }

    @Test
    public void checkGetReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("(==== Test Bun ====)"));
        assertTrue(receipt.contains("= filling Test Ingredient1 ="));
        assertTrue(receipt.contains("= sauce Test Ingredient2 ="));
        assertTrue(receipt.contains("(==== Test Bun ====)"));
        assertTrue(receipt.contains("Price: 275,000000"));
    }

}
