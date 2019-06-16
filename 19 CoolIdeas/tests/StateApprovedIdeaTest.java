import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StateApprovedIdeaTest extends JStateBaseTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
        i.hold();
        i.hold();
    }

    @Test
    public void testRelease() {
        i.release();
        assertEquals("ApprovedIdea.release() should change the state to ReleasedIdea!", getClassReleasedIdea(), getState()
                .getClass());
    }

    @Test
    public void testIllegalStateExceptions() {
        try {
            i.hold();
            fail("ApprovedIdea.hold() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.decline();
            fail("ApprovedIdea.decline() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.discuss("Test");
            fail("ApprovedIdea.discuss() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.evaluate(new JValuation("title", "description"));
            fail("ApprovedIdea.evaluate() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
