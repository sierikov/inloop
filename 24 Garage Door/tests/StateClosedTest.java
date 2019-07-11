import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StateClosedTest extends DoorStateBaseTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testOpenDoor() {
        gd.openDoor();
        assertEquals("Closed.openDoor() should change the state to Opening!", classOpening, getState().getClass());
    }

    @Test
    public void testIllegalStateExceptions() {
        try {
            gd.stopper();
            fail("Closed.stopper() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            gd.closeDoor();
            fail("Closed.closeDoor() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
