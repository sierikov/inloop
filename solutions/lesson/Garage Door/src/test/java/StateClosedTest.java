import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StateClosedTest extends DoorStateBaseTest {
    @Test
    public void testOpenDoor() {
        garageDoor.openDoor();
        assertEquals("Closed.openDoor() should change the state to Opening!", "Opening", getCurrentStateName());
    }

    @Test
    public void testIllegalStateExceptions() {
        try {
            garageDoor.stopper();
            fail("Closed.stopper() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            garageDoor.closeDoor();
            fail("Closed.closeDoor() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
