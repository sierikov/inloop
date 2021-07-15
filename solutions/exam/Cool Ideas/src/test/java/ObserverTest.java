import static java.lang.reflect.Modifier.isInterface;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Checking-code for io-streams is from:
// https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

public class ObserverTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private PrintStream backOut, backErr;

    private JMember m1, m2;
    private JTopic t1, t2;


    @Before
    public void setUp() {
        backOut = System.out;
        backErr = System.err;

        try {
            System.setOut(new PrintStream(outContent, false, "UTF-8"));
            System.setErr(new PrintStream(errContent, false, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new UncheckedIOException("UTF-8 is not supported.", e);
        }

        m1 = new JMember();
        m2 = new JMember();
        t1 = new JTopic("title1", "description1", 1);
        t2 = new JTopic("title2", "description2", 2);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(backOut);
        System.setErr(backErr);
    }

    // A method comparing the String streamOutput with the actual streams
    private void testStreams(String message, String streamOutput) {
        try {
            assertEquals(message, streamOutput + System.lineSeparator(), outContent.toString("UTF-8"));
            assertEquals("Your program should not print into the error stream (System.err)!", "", errContent.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new UncheckedIOException("UTF-8 is not supported.", e);
        }
        outContent.reset();
        errContent.reset();
    }

    @Test
    public void testStructure() {
        assertTrue("ContentObserver should be an interface!",
                isInterface(ContentObserver.class.getModifiers()));
        assertTrue("JMember should implement ContentObserver!",
                ContentObserver.class.isAssignableFrom(JMember.class));
    }

    @Test
    public void testSubscribe() {
        m1.subscribe(t1);
        assertTrue("JMember.subscribe() should add the topic to the member's subscribed topics!", m1
                .getSubscribedTopics().contains(t1));
        assertEquals("JMember.subscribe() should add the JMember as an Observer of the topic!", 1, t1.countObservers());

        m1.subscribe(t2);
        assertTrue("JMember.subscribe() should add the topic to the member's subscribed topics!", m1
                .getSubscribedTopics().contains(t2));
        assertEquals("JMember.subscribe() should add the JMember as an Observer of the topic!", 1, t2.countObservers());

        m2.subscribe(t2);
        assertTrue("JMember.subscribe() should add the topic to the member's subscribed topics!", m2
                .getSubscribedTopics().contains(t2));
        assertEquals("JMember.subscribe() should add the JMember as an Observer of the topic!", 2, t2.countObservers());

        m1.subscribe(t1);
        assertEquals("JMember.subscribe() should not add the JMember as an Observer of a topic more than once!", 1,
                t1.countObservers());

        m1.subscribe(t2);
        assertEquals("JMember.subscribe() should not add the JMember as an Observer of a topic more than once!", 2,
                t2.countObservers());
    }

    @Test
    public void testUnsubscribe() {
        m1.subscribe(t1);
        m1.subscribe(t2);
        m2.subscribe(t2);

        m1.unsubscribe(t2);
        assertFalse("JMember.unsubscribe() should remove the topic from the member's subscribed topics!", m1
                .getSubscribedTopics().contains(t2));
        assertEquals("JMember.unsubscribe() should remove the JMember as an Observer of the topic!", 1,
                t2.countObservers());

        m1.unsubscribe(t1);
        assertFalse("JMember.unsubscribe() should add the topic to the member's subscribed topics!", m1
                .getSubscribedTopics().contains(t1));
        assertEquals("JMember.unsubscribe() should add the JMember as an Observer of the topic!", 0,
                t1.countObservers());

        m2.unsubscribe(t1);
        assertTrue("JMember.unsubscribe() should only remove topics subscribed by the member!", m2
                .getSubscribedTopics().contains(t2));
        assertEquals("JMember.unsubscribe() should add the JMember as an Observer of the topic!", 1,
                t2.countObservers());

        m2.unsubscribe(t2);
        assertFalse("JMember.unsubscribe() should add the topic to the member's subscribed topics!", m2
                .getSubscribedTopics().contains(t2));
        assertEquals("JMember.unsubscribe() should add the JMember as an Observer of the topic!", 0,
                t2.countObservers());
    }

    @Test
    public void testNotifications() {
        m1.subscribe(t1);
        m1.subscribe(t2);
        m2.subscribe(t2);

        t1.setTitle("newTitle1");
        testStreams("JMember.update() should print the correct log message when a topic is updated!", "The topic "
                + t1.getId() + " has been updated!");
        t1.setDescription("newDescription1");
        testStreams("JMember.update() should print the correct log message when a topic is updated!", "The topic "
                + t1.getId() + " has been updated!");

        t2.setTitle("newTitle2");
        testStreams("JMember.update() should print the correct log message when a topic is updated!", "The topic "
                + t2.getId() + " has been updated!" + System.lineSeparator() + "The topic " + t2.getId()
                + " has been updated!");
        t2.setDescription("newDescription2");
        testStreams("JMember.update() should print the correct log message when a topic is updated!", "The topic "
                + t2.getId() + " has been updated!" + System.lineSeparator() + "The topic " + t2.getId()
                + " has been updated!");
    }
}
