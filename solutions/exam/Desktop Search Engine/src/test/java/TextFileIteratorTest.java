import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class TextFileIteratorTest {
    private TextFileIterator tfi;

    @Before
    public void setUp() {
        tfi = new TextFileIterator(new Resource("text.txt", "/home/user/textfiles/", new ResourceType(
                "Plain Text File", new PlainTextCollector())));
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new TextFileIterator(null);
            fail("TextFileIterator.TextFileIterator() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testIterator() {
        String[] expected = "We wish you good luck in this exam We hope you are well prepared".split(" ");
        for (int i = 0; i < expected.length; i++) {
            assertTrue("TextFileIterator.hasNext() should return true if there is another word in the text!",
                    tfi.hasNext());
            assertEquals("TextFileIterator.next() should return the correct next word!", expected[i], tfi.next());
        }
        assertFalse("TextFileIterator.hasNext() should return false if there is no next word!", tfi.hasNext());
        try {
            tfi.next();
            fail("TextFileIterator.next() should throw a NoSuchElementException if there is no next word!");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void testRemove() {
        try {
            tfi.remove();
            fail("TextFileIterator.remove() should throw an UnsupportedOperationException upon being called!");
        } catch (UnsupportedOperationException e) {
        }
    }
}
