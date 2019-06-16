import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class JTopicTest extends JContentTest {
    private JTopic jTopic;

    @Override
    @Before
    public void setUp() {
        jTopic = new JTopic("title", "description", 1);
        jContent = jTopic;
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new JTopic(null, "description", 0);
            fail("JTopic.JTopic() should throw a NullPointerException if the title argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new JTopic("title", null, 0);
            fail("JTopic.JTopic() should throw a NullPointerException if the description argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new JTopic(null, null, 0);
            fail("JTopic.JTopic() should throw a NullPointerException if the title and the description argument are null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorInvalidArgument() {
        try {
            new JTopic("", "description", 0);
            fail("JTopic.JTopic() should throw an IllegalArgumentException if the title argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new JTopic("title", "", 0);
            fail("JTopic.JTopic() should throw an IllegalArgumentException if the description argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new JTopic("", "", 0);
            fail("JTopic.JTopic() should throw an IllegalArgumentException if the title and the description argument are empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetId() {
        assertEquals("JTopic.getId() should return the correct ID!", jTopic.getId(), 1);
    }

    @Test
    public void testToString() {
        assertEquals("JTopic.toString() should return the correct String!", "Topic: title\ndescription",
                jTopic.toString());
    }
}
