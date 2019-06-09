import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class WineTest {
    @Test
    public void testAbstract() {
        assertTrue("The class Wine should be an abstract class!", Modifier.isAbstract(Wine.class.getModifiers()));
    }

    @Test
    public void testExtendsDrink() {
        assertTrue("The class Wine should extend Drink!", Wine.class.getSuperclass().equals(Drink.class));
    }

    @Test
    public void testOverrideToString() {
        try {
            Wine.class.getDeclaredMethod("toString");
        } catch(NoSuchMethodException e) {
            fail("The class Wine should override toString()!");
        }
    }

    @Test
    public void testGetRegion() {
        Wine wine = new Wine("Pfalz") {};
        assertEquals("Wine.getRegion() should return the correct region!", "Pfalz", wine.getRegion());
    }
}