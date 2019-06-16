import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StateReleasedIdeaTest extends JStateBaseTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
        i.hold();
        i.hold();
        i.release();
    }

    @Test
    public void testIllegalStateExceptions() {
        try {
            i.hold();
            fail("ReleasedIdea.hold() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.decline();
            fail("ReleasedIdea.decline() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.discuss("Test");
            fail("ReleasedIdea.discuss() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.evaluate(new JValuation("title", "description"));
            fail("ReleasedIdea.evaluate() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.release();
            fail("ReleasedIdea.release() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
