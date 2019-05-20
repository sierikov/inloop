import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class KeywordCollectorTest {
    private KeywordCollector coll;

    @Test
    public void testInterface() {
        assertTrue(KeywordCollector.class.isInterface());
    }

    @Test
    public void testDefaultCollectorGetKeywordsNullArgument() {
        try {
            new DefaultCollector().getKeywords(null);
            fail("DefaultCollector.getKeywords() should throw a NullPointerException if the res argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testDefaultCollectorGetKeywords() {
        coll = new DefaultCollector();
        Set<String> keywords = coll.getKeywords(new Resource("name", "path", new ResourceType("desc", coll)));
        assertTrue(
                "DefaultCollector.getKeywords() should return a set containing only the name of the specified resource!",
                keywords.size() == 1 && keywords.contains("name"));

        keywords = coll.getKeywords(new Resource("name 2", "path", new ResourceType("desc", coll)));
        assertTrue(
                "DefaultCollector.getKeywords() should return a set containing only the name of the specified resource" +
                        "and should not store the previous ones!",
                keywords.size() == 1 && keywords.contains("name 2"));
    }

    @Test
    public void testPlainTextCollectorGetKeywordsNullArgument() {
        try {
            new PlainTextCollector().getKeywords(null);
            fail("PlainTextCollector.getKeywords() should throw a NullPointerException if the res argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testPlainTextCollectorGetKeywords() {
        coll = new PlainTextCollector();
        Set<String> keywords = coll.getKeywords(new Resource("name", "path", new ResourceType("desc", coll)));
        Set<String> expected = new HashSet<String>(
                Arrays.asList("are exam good hope in luck prepared this We well wish you".split(" ")));
        assertEquals(
                "PlainTextCollector.getKeywords() should return a set containing every word within the String given in the task description!",
                expected, keywords);
    }

}
