import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StateClosingTest extends DoorStateBaseTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
        garageDoor.openDoor();
        garageDoor.closeDoor();
    }

    @Test
    public void testOpenDoor() {
        garageDoor.openDoor();
        assertEquals("Closing.openDoor() should change the state to Opening!", "Opening",
                getCurrentStateName());
    }

    @Test
    public void testStopper() {
        garageDoor.stopper();
        assertEquals("Closing.stopper() should change the state to Closed!", "Closed",
                getCurrentStateName());
    }

    @Test
    public void testIllegalStateExceptions() {
        try {
            garageDoor.closeDoor();
            fail("Closed.closeDoor() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
