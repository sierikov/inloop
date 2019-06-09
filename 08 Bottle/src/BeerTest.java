import org.junit.Test;

import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;
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
            fail("The class Beer should have a method with the name \"getRegion()\"!");
        }
        try {
            Beer.class.getDeclaredMethod("toString");
        } catch(NoSuchMethodException e) {
            fail("The class Beer should override toString()!");
        }
    }

    @Test
    public void testGetBrewery() {
        Beer b = new Beer("Freiberger");
        assertEquals("Beer.getRegion() should return the correct brewery!", "Freiberger", b.getBrewery());
    }
}