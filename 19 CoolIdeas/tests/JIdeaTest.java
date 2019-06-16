import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JIdeaTest extends JContentTest {
    private JIdea jIdea;
    private JAttachment a = new JAttachment("titleA", "descriptionA", new File("/dev/null"));
    private JAttachment b = new JAttachment("titleB", "descriptionB", new File("/dev/null"));
    private JAttachment c = new JAttachment("titleC", "descriptionC", new File("/dev/null"));
    private List<JAttachment> expAttachments = Arrays.asList(new JAttachment[] { a, b, c });

    @Override
    @Before
    public void setUp() {
        jIdea = new JIdea("title", "description");
        jContent = jIdea;
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new JIdea(null, "description");
            fail("JIdea.JIdea() should throw a NullPointerException if the title argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new JIdea("title", null);
            fail("JIdea.JIdea() should throw a NullPointerException if the description argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new JIdea(null, null);
            fail("JIdea.JIdea() should throw a NullPointerException if the title and the description argument are null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new JIdea("", "description");
            fail("JIdea.JIdea() should throw an IllegalArgumentException if the title argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new JIdea("title", "");
            fail("JIdea.JIdea() should throw an IllegalArgumentException if the description argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new JIdea("", "");
            fail("JIdea.JIdea() should throw an IllegalArgumentException if the title and the description argument are empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testIsDeclined() {
        assertFalse("JIdea.isDeclined() should return false if the state is not DeclinedIdea!", jIdea.isDeclined());
        jIdea.hold();
        assertFalse("JIdea.isDeclined() should return false if the state is not DeclinedIdea!", jIdea.isDeclined());
        jIdea.hold();
        assertFalse("JIdea.isDeclined() should return false if the state is not DeclinedIdea!", jIdea.isDeclined());
        jIdea.release();
        assertFalse("JIdea.isDeclined() should return false if the state is not DeclinedIdea!", jIdea.isDeclined());
        jIdea = new JIdea("title", "description");
        jIdea.decline();
        assertTrue("JIdea.isDeclined() should return true if the state is DeclinedIdea!", jIdea.isDeclined());

    }

    @Test
    public void testIsReleased() {
        assertFalse("JIdea.isReleased() should return false if the state is not ReleasedIdea!", jIdea.isReleased());
        jIdea.hold();
        assertFalse("JIdea.isReleased() should return false if the state is not ReleasedIdea!", jIdea.isReleased());
        jIdea.hold();
        assertFalse("JIdea.isReleased() should return false if the state is not ReleasedIdea!", jIdea.isReleased());
        jIdea.release();
        assertTrue("JIdea.isReleased() should return true if the state is ReleasedIdea!", jIdea.isReleased());
        jIdea = new JIdea("title", "description");
        jIdea.decline();
        assertFalse("JIdea.isReleased() should return false if the state is not ReleasedIdea!", jIdea.isReleased());

    }

    @Test
    public void testAddAttachmentNullArgument() {
        try {
            jIdea.addAttachment(null);
            fail("JIdea.addAttachment() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetAttachments() {
        jIdea.addAttachment(a);
        jIdea.addAttachment(b);
        jIdea.addAttachment(c);
        List<JAttachment> actualAttachments = jIdea.getAttachments();

        for (JAttachment attachment : expAttachments) {
            assertTrue("JIdea.getAttachments() should return every attachment of a JIdea!",
                    expAttachments.contains(attachment));
        }
        assertEquals("JIdea.getAttachments() should return nothing more than the JIdea's attachments!",
                actualAttachments.size(), expAttachments.size());
    }

    @Test
    public void testRemoveAttachmentNullArgument() {
        try {
            jIdea.removeAttachment(null);
            fail("JIdea.removeAttachment() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testRemoveAttachment() {
        assertFalse("JIdea.removeAttachment() should return false if the JIdea did not contain the attachment!",
                jIdea.removeAttachment(a));

        jIdea.addAttachment(a);
        jIdea.addAttachment(b);
        jIdea.addAttachment(c);

        for (JAttachment attachment : expAttachments) {
            assertTrue("JIdea.removeAttachment() should return true if the JIdea did contain the attachment!",
                    jIdea.removeAttachment(attachment));
            assertFalse("JIdea.removeAttachment() should actually delete the attachment!", jIdea.getAttachments()
                    .contains(attachment));
        }
    }

    @Test
    public void testToString() {
        String expResult = "Idea: title\ndescription";
        assertEquals("JIdea.toString() does not work correctly.", expResult, jIdea.toString());
    }
}
