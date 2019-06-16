import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class JIdeaPoolTest {
    private JIdeaPool ideaPool;
    private final JIdea i1 = new JIdea("titleIdea1", "descriptionIdea1");
    private final JIdea i2 = new JIdea("titleIdea2", "descriptionIdea2");
    private final JIdea i3 = new JIdea("titleIdea3", "descriptionIdea3");
    private final JTopic t1 = new JTopic("titleTopic1", "descriptionTopic1", 1);
    private final JTopic t2 = new JTopic("titleTopic2", "descriptionTopic2", 2);
    private final JTopic t3 = new JTopic("titleTopic3", "descriptionTopic3", 3);

    @Before
    public void setUp() {
        ideaPool = new JIdeaPool();
    }

    @Test
    public void testAddNullArgument() {
        try {
            ideaPool.add(null);
            fail("JIdeaPool.add(JTopic) should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            ideaPool.add(null, t1);
            fail("JIdeaPool.add(JIdea, JTopic) should throw a NullPointerException if the idea argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            ideaPool.add(i1, null);
            fail("JIdeaPool.add(JIdea, JTopic) should throw a NullPointerException if the topic argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            ideaPool.add(null, null);
            fail("JIdeaPool.add(JIdea, JTopic) should throw a NullPointerException if the both arguments are null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddJTopic() {
        ideaPool.add(t1);
        Map<JTopic, Set<JIdea>> actPool = getPool();
        assertTrue("JIdeaPool.add(JTopic) should map a topic not contained in the pool to an empty Set!",
                actPool.get(t1).isEmpty());
        ideaPool.add(i1, t1);
        ideaPool.add(t1);
        assertTrue("JIdeaPool.add(JTopic) should not remove any existing JIdea mappings in the pool!", actPool.get(t1)
                .contains(i1));
    }

    @Test
    public void testAddJIdeaJTopic() {
        Map<JTopic, Set<JIdea>> actPool = getPool();
        final JIdea ideaWithExistingTitle = new JIdea(i1.getTitle(), "already existing title");

        ideaPool.add(i1, t1);
        assertTrue("JIdeaPool.add(JIdea, JTopic) should add the topic if the pool did not contain it!",
                actPool.containsKey(t1));
        assertTrue("JIdeaPool.add(JIdea, JTopic) should add the idea to the set of ideas of the given topic!", actPool
                .get(t1).size() == 1 && actPool.get(t1).contains(i1));

        ideaPool.add(ideaWithExistingTitle, t1);
        assertFalse(
                "JIdeaPool.add(JIdea, JTopic) should not add an idea if the pool already contains another idea with the same title!",
                actPool.get(t1).contains(ideaWithExistingTitle));

        ideaPool.add(ideaWithExistingTitle, t2);
        assertFalse("JIdeaPool.add(JIdea, JTopic) should not add the topic to the pool if the idea is not added!",
                actPool.containsKey(t2));

        ideaPool.add(i3, t1);
        assertTrue("JIdeaPool.add(JIdea, JTopic) should add the idea to the set of ideas of the given topic!", actPool
                .get(t1).size() == 2 && actPool.get(t1).contains(i3));

        ideaPool.add(i1, t2);
        assertTrue("JIdeaPool.add(JIdea, JTopic) should add the idea to the set of ideas of the given topic even if"
                + " the idea is already associated to another topic!", actPool.containsKey(t2)
                && actPool.get(t2).size() == 1 && actPool.get(t2).contains(i1));
    }

    @Test
    public void testRemoveNullArgument() {
        try {
            ideaPool.remove((JTopic) null);
            fail("JIdeaPool.remove(JTopic) should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            ideaPool.remove((JIdea) null);
            fail("JIdeaPool.remove(JIdea) should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testRemoveJTopic() {
        ideaPool.add(t1);
        ideaPool.add(t3);
        assertTrue(
                "JIdeaPool.remove(JTopic) should return true if the given topic exists in the pool and was removed!",
                ideaPool.remove(t1));
        assertTrue(
                "JIdeaPool.remove(JTopic) should return true if the given topic exists in the pool and was removed!",
                ideaPool.remove(t3));
        assertFalse("JIdeaPool.remove(JTopic) should return false if the given topic does not exist in the pool!",
                ideaPool.remove(t1));
        assertFalse("JIdeaPool.remove(JTopic) should return false if the given topic does not exist in the pool!",
                ideaPool.remove(t2));
        assertFalse("JIdeaPool.remove(JTopic) should return false if the given topic does not exist in the pool!",
                ideaPool.remove(t3));
    }

    @Test
    public void testRemoveJIdea() {
        ideaPool.add(i1, t1);
        ideaPool.add(i1, t2);
        ideaPool.add(i3, t2);
        assertTrue("JIdeaPool.remove(JIdea) should return true if the given idea exists in the pool and was removed!",
                ideaPool.remove(i1));
        assertNull("JIdeaPool.remove(JIdea) should remove the idea from every topic!", ideaPool.getIdea(i1.getTitle()));
        assertTrue("JIdeaPool.remove(JIdea) should return true if the given idea exists in the pool and was removed!",
                ideaPool.remove(i3));
        assertFalse("JIdeaPool.remove(JIdea) should return false if the given idea does not exist in the pool!",
                ideaPool.remove(i1));
        assertFalse("JIdeaPool.remove(JIdea) should return false if the given idea does not exist in the pool!",
                ideaPool.remove(i2));
        assertFalse("JIdeaPool.remove(JIdea) should return false if the given idea does not exist in the pool!",
                ideaPool.remove(i3));
    }

    @Test
    public void testRemoveDeclined() {
        ideaPool.add(i1, t1);
        ideaPool.add(i2, t1);
        ideaPool.add(i3, t2);
        ideaPool.add(i1, t2);

        i1.decline();
        ideaPool.removeDeclined();
        assertNull("JIdeaPool.removeDeclined() should remove all declined ideas!", ideaPool.getIdea(i1.getTitle()));
        i2.decline();
        i3.decline();
        ideaPool.removeDeclined();
        assertNull("JIdeaPool.removeDeclined() should remove all declined ideas!", ideaPool.getIdea(i2.getTitle()));
        assertNull("JIdeaPool.removeDeclined() should remove all declined ideas!", ideaPool.getIdea(i3.getTitle()));
    }

    @Test
    public void testRemoveReleased() {
        ideaPool.add(i1, t1);
        ideaPool.add(i2, t1);
        ideaPool.add(i3, t2);
        ideaPool.add(i1, t2);

        i1.hold();
        i1.hold();
        i1.release();
        ideaPool.removeReleased();
        assertNull("JIdeaPool.removeDeclined() should remove all declined ideas!", ideaPool.getIdea(i1.getTitle()));
        i2.hold();
        i2.hold();
        i2.release();
        i3.hold();
        i3.hold();
        i3.release();
        ideaPool.removeReleased();
        assertNull("JIdeaPool.removeDeclined() should remove all declined ideas!", ideaPool.getIdea(i2.getTitle()));
        assertNull("JIdeaPool.removeDeclined() should remove all declined ideas!", ideaPool.getIdea(i3.getTitle()));
    }

    @Test
    public void testGetIdeaIllegalArgument() {
        try {
            ideaPool.getIdea(null);
            fail("JIdeaPool.getIdea() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            ideaPool.getIdea("");
            fail("JIdeaPool.getIdea() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetIdea() {
        ideaPool.add(i1, t1);
        ideaPool.add(i1, t2);
        ideaPool.add(i3, t2);

        assertEquals("JIdeaPool.getIdea() should return the idea with the given title!", i1,
                ideaPool.getIdea("titleIdea1"));
        assertEquals("JIdeaPool.getIdea() should return the idea with the given title!", i3,
                ideaPool.getIdea("titleIdea3"));
        assertNull(
                "JIdeaPool.getIdea() should return null if the pool does not contain any idea with the given title!",
                ideaPool.getIdea("notInThePool"));
    }

    @Test
    public void testNumberOfTopics() {
        ideaPool.add(t1);
        assertEquals("JIdeaPool.numberOfTopics() should return the right number of topics in the pool!", 1,
                ideaPool.numberOfTopics());
        ideaPool.add(t2);
        assertEquals("JIdeaPool.numberOfTopics() should return the right number of topics in the pool!", 2,
                ideaPool.numberOfTopics());
        ideaPool.add(t3);
        assertEquals("JIdeaPool.numberOfTopics() should return the right number of topics in the pool!", 3,
                ideaPool.numberOfTopics());
    }

    @Test
    public void testNumberOfIdeas() {
        ideaPool.add(i1, t1);
        assertEquals("JIdeaPool.numberOfIdeas() should return the right number of ideas in the pool!", 1,
                ideaPool.numberOfIdeas());
        ideaPool.add(i2, t1);
        assertEquals("JIdeaPool.numberOfIdeas() should return the right number of ideas in the pool!", 2,
                ideaPool.numberOfIdeas());
        ideaPool.add(i2, t2);
        assertEquals("JIdeaPool.numberOfIdeas() should count each individual idea only once!", 2,
                ideaPool.numberOfIdeas());
        ideaPool.add(i3, t2);
        assertEquals("JIdeaPool.numberOfIdeas() should return the right number of ideas in the pool!", 3,
                ideaPool.numberOfIdeas());
    }

    @SuppressWarnings("unchecked")
    private Map<JTopic, Set<JIdea>> getPool() {
        // Get attribute pool, set the mode to accessible and return the content
        try {
            Field myField = ideaPool.getClass().getDeclaredField("pool");
            myField.setAccessible(true);
            Object pool = myField.get(ideaPool);
            if (!(pool instanceof Map<?, ?>)) {
                fail("JIdeaPool.pool should be a Map<JTopic, Set<JIdea>>!");
            }
            return (Map<JTopic, Set<JIdea>>) pool;
        } catch (NoSuchFieldException e) {
            throw new AssertionError("JIdeaPool should have an attribute named pool!");
        } catch (IllegalArgumentException e) {
            fail("An unexpected error occurred!");
        } catch (IllegalAccessException e) {
            fail("An unexpected error occurred!");
        }
        throw new RuntimeException("An unexpected error occurred!");
    }
}
