import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class JContentTest {
    protected JContent jContent;

    @Before
    public void setUp() {
        jContent = new JContentImpl("title", "description");
    }

    @Test
    public void testAbstract() {
        assertTrue("JContent should be abstract!", Modifier.isAbstract(JContent.class.getModifiers()));
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new JContentImpl(null, "description");
            fail("JContent.JContent() should throw a NullPointerException if the title argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new JContentImpl("title", null);
            fail("JContent.JContent() should throw a NullPointerException if the description argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new JContentImpl(null, null);
            fail("JContent.JContent() should throw a NullPointerException if the arguments are null!");
        } catch (NullPointerException e) {
        }

        try {
            new JContentImpl("", "description");
            fail("JContent.JContent() should throw an IllegalArgumentException if the title argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new JContentImpl("title", "");
            fail("JContent.JContent() should throw an IllegalArgumentException if the description argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new JContentImpl("", "");
            fail("JContent.JContent() should throw an IllegalArgumentException if the arguments are empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetTitle() {
        assertEquals("JContent.getTitle() should return the correct title!", "title", jContent.getTitle());
    }

    @Test
    public void testSetTitleIllegalArgument() {
        try {
            jContent.setTitle(null);
            fail("JContent.setTitle() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            jContent.setTitle("");
            fail("JContent.setTitle() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testSetTitle() {
        jContent.setTitle("newTitle");
        assertEquals("JContent.setTitle() should set the title correctly!", "newTitle", jContent.getTitle());
    }

    @Test
    public void testGetDescription() {
        assertEquals("JContent.getDescription() should return the correct description!", "description",
                jContent.getDescription());
    }

    @Test
    public void testSetDescriptionIllegalArgument() {
        try {
            jContent.setDescription(null);
            fail("JContent.setDescription() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            jContent.setDescription("");
            fail("JContent.setDescription() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testSetDescription() {
        jContent.setDescription("newDescription");
        assertEquals("JContent.setDescription() should set the description correctly!", "newDescription",
                jContent.getDescription());
    }

    private static class JContentImpl extends JContent {
        public JContentImpl(String title, String description) {
            super(title, description);
        }

        @Override
        public String toString() {
            return "";
        }
    }
}
