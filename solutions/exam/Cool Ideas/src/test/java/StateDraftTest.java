import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StateDraftTest extends JStateBaseTest {
    @Test
    public void testHold() {
        i.hold();
        assertEquals("Draft.hold() should change the state to OpenDraft!", getClassOpenDraft(), getState().getClass());
    }

    @Test
    public void testDecline() {
        i.decline();
        assertEquals("Draft.decline() should change the state to DeclinedIdea!", getClassDeclinedIdea(), getState()
                .getClass());
    }

    @Test
    public void testIllegalStateExceptions() {
        try {
            i.discuss("Test");
            fail("Draft.discuss() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.evaluate(new JValuation("title", "description"));
            fail("Draft.evaluate() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.release();
            fail("Draft.release() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
