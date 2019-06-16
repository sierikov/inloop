import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class JAttachmentTest extends JContentTest {
    private JAttachment jAttachment;

    @Override
    @Before
    public void setUp() {
        jAttachment = new JAttachment("title", "description", new File("/dev/null"));
        jContent = jAttachment;
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new JAttachment("title", "description", null);
            fail("JAttachment.JAttachment() should throw a NullPointerException if the File argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        File file = new File("/dev/null");

        try {
            new JAttachment("", "description", file);
            fail("JAttachment.JAttachment() should throw an IllegalArgumentException if the title argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try{
            new JAttachment("", "", file);
            fail("JAttachment.JAttachment() should throw an IllegalArgumentException if the description argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new JAttachment("", "", file);
            fail("JAttachment.JAttachment() should throw an IllegalArgumentException if the title and the description argument are empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetFile() {
        assertEquals("JAttachment.getFile() does not work correctly!", new File("/dev/null"), jAttachment.getFile());
    }

    @Test
    public void testSetFileNullArgument() {
        try {
            jAttachment.setFile(null);
            fail("JAttachment.setFile() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testSetFile() {
        File expResult = new File("/etc/X11");
        jAttachment.setFile(expResult);
        assertEquals("JAttachment.setFile() should set the file correctly!", expResult, jAttachment.getFile());
    }

    @Test
    public void testToString() {
        assertEquals("JAttachment.toString() should return the correct String!", "Attachment: title\ndescription",
                jAttachment.toString());
    }
}
