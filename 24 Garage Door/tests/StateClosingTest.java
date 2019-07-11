import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StateClosingTest extends DoorStateBaseTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
        gd.openDoor();
        gd.closeDoor();
    }

    @Test
    public void testOpenDoor() {
        gd.openDoor();
        assertEquals("Closing.openDoor() should change the state to Opening!", classOpening, getState().getClass());
    }

    @Test
    public void testStopper() {
        gd.stopper();
        assertEquals("Closing.stopper() should change the state to Closed!", classClosed, getState().getClass());
    }

    @Test
    public void testIllegalStateExceptions() {
        try {
            gd.closeDoor();
            fail("Closed.closeDoor() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
