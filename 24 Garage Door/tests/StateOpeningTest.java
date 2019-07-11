import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StateOpeningTest extends DoorStateBaseTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
        gd.openDoor();
    }

    @Test
    public void testCloseDoor() {
        gd.closeDoor();
        assertEquals("Opening.closeDoor() should change the state to Closing!", classClosing, getState().getClass());
    }

    @Test
    public void testStopper() {
        gd.stopper();
        assertEquals("Opening.stopper() should change the state to Open!", classOpen, getState().getClass());
    }

    @Test
    public void testIllegalStateExceptions() {
        try {
            gd.openDoor();
            fail("Opening.openDoor() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
