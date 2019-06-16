import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StateDeclinedIdeaTest extends JStateBaseTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
        i.decline();
    }

    @Test
    public void testIllegalStateExceptions() {
        try {
            i.hold();
            fail("DeclinedIdea.hold() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.decline();
            fail("DeclinedIdea.decline() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.discuss("Test");
            fail("DeclinedIdea.discuss() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.evaluate(new JValuation("title", "description"));
            fail("DeclinedIdea.evaluate() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

        try {
            i.release();
            fail("DeclinedIdea.release() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }

    }
}
