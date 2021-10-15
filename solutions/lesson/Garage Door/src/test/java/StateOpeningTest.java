import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StateOpeningTest extends DoorStateBaseTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
        garageDoor.openDoor();
    }

    @Test
    public void testCloseDoor() {
        garageDoor.closeDoor();
        assertEquals("Opening.closeDoor() should change the state to Closing!", "Closing",
                getCurrentStateName());
    }

    @Test
    public void testStopper() {
        garageDoor.stopper();
        assertEquals("Opening.stopper() should change the state to Open!", "Open",
                getCurrentStateName());
    }

    @Test
    public void testIllegalStateExceptions() {
        try {
            garageDoor.openDoor();
            fail("Opening.openDoor() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
