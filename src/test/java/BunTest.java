import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"black bun", 2.3f},
                {"white bun", 3.5f},
                {"red bun", 4.0f}
        };
    }

    @Test
    public void checkReturnCorrectName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void checkReturnCorrectPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.0001);
    }
}

