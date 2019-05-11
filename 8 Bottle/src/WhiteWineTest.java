import org.junit.Test;

import static org.junit.Assert.*;

public class WhiteWineTest {
    @Test
    public void testExtendsDrink() {
        assertTrue("The class WhiteWine should extend Wine!", WhiteWine.class.getSuperclass().equals(Wine.class));
    }

    @Test
    public void testGetRegion() {
        WhiteWine ww = new WhiteWine("Dresden");
        assertEquals("WhiteWine.getRegion() should return the correct region!", "Dresden", ww.getRegion());
    }
}