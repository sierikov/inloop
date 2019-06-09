import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class BottleTest {
    private Beer beer;
    private Bottle<Beer> bottle;

    @Before
    public void setUp() {
        beer = new Beer("Hasseröder");
        bottle = new Bottle<Beer>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Bottle.isEmpty() should return true if the Bottle is empty!", bottle.isEmpty());
        bottle.fill(beer);
        assertFalse("Bottle.isEmpty() should return false if the Bottle is not empty!", bottle.isEmpty());
        bottle.empty();
        assertTrue("Bottle.isEmpty() should return true if the Bottle has been emptied!", bottle.isEmpty());
    }

    @Test
    public void testFill() {
        bottle.fill(beer);

        Field f = null;
        try {
            f = bottle.getClass().getDeclaredField("content");
        } catch (NoSuchFieldException e) {
            fail("The class Bottle should contain an Object with the name \"content\"");
        }
        f.setAccessible(true);

        Beer content = null;
        try {
            content = castToBeer(f.get(bottle));
        } catch(IllegalAccessException e) {
            fail("The class Bottle should contain an Object with the name \"content\"");
        } catch(ClassCastException e) {
            fail("The attribute \"content\" in the class Bottle should be of type \"<T extends Drink>\"");
        }

        assertTrue(content.equals(beer));
    }

    @SuppressWarnings("unchecked")
    private Beer castToBeer(Object o) {
        return (Beer) o;
    }

    @Test
    public void testFillIllegalState() {
        bottle.fill(beer);
        try {
            bottle.fill(beer);
            fail("Bottle.fill() should throw an IllegalStateException if the Bottle is in an invalid state for the operation!");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testEmpty() {
        bottle.fill(beer);
        assertEquals("Bottle.empty() should return the same Drink which was put into the Bottle!", beer,
                bottle.empty());
    }

    @Test
    public void testEmptyIllegalState() {
        try {
            bottle.empty();
            fail("Bottle.empty() should throw an IllegalStateException if the Bottle is in an invalid state for the operation!");
        } catch (IllegalStateException e) {
        }
    }
}
