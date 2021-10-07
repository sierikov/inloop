import org.junit.Test;

import static org.junit.Assert.*;

public class BeerTest {
    @Test
    public void testExtendsDrink() {
        assertTrue("The class Beer should extend Drink!", Beer.class.getSuperclass().equals(Drink.class));
    }

    @Test
    public void testRightMethods() {
        try {
            Beer.class.getDeclaredMethod("getBrewery");
        } catch(NoSuchMethodException e) {
            fail("The class Beer should have a method with the name \"getBrewery()\"!");
        }
        try {
            Beer.class.getDeclaredMethod("toString");
        } catch(NoSuchMethodException e) {
            fail("The class Beer should override toString()!");
        }
    }

    @Test
    public void testGetBrewery() {
        Beer beer = new Beer("Freiberger");
        assertEquals("Beer.getBrewery() should return the correct brewery!", "Freiberger", beer.getBrewery());
    }
}
