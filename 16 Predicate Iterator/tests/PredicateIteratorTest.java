import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class PredicateIteratorTest {
    private PredicateIterator<String> preditsw;
    private Collection<String> testList;

    @Before
    public void setUp() {
        testList = new LinkedList<>();

        testList.add("Test1");
        testList.add("nonevalid");
        testList.add("nonevalid");
        testList.add("nonevalid");
        testList.add("Test");
        testList.add("Test2");

        preditsw = new PredicateIterator<>(testList.iterator(), new PredicateStartsWith<>(), "T");
    }

    @Test
    public void testFirstNext() {
        assertEquals(
                "PredicateIterator.next() did not return the first matching element of a data structure correctly!",
                "Test1", preditsw.next());
    }

    @Test
    public void testIntermediateNext() {
        preditsw.next();
        assertEquals(
                "PredicateIterator.next() did not return an intermediate matching element of a data structure correctly!",
                "Test", preditsw.next());
    }

    @Test
    public void testLastNext() {
        for (int i = 0; i < 2; i++) {
            preditsw.next();
        }
        assertEquals(
                "PredicateIterator.next() did not return the last matching element of a data structure correctly!",
                "Test2", preditsw.next());
    }

    @Test
    public void testBehindLastNext() {
        int i = 0;
        try {
            for (; i < 4; i++) {
                preditsw.next();
            }
        } catch (NoSuchElementException e) {
            if (i < 3) {
                fail("PredicateIterator.next() shouldn't throw a NoSuchElementException when there are still matching elements to provide!");
            }
            if (i == 3) {
                return;
            }
        }
        fail("PredicateIterator.next() should throw a NoSuchElementException after the last matching element of the data structure has been provided!");
    }

    @Test
    public void testHasNextWithoutAdvancing() {
        try {
            for (int i = 0; i < 20; i++) {
                assertTrue("PredicateIterator.hasNext() should return true when there is a next matching element!",
                        preditsw.hasNext());
            }
        } catch (NoSuchElementException e) {
            fail("PredicateIterator.hasNext() should not cause a NoSuchElementException to be thrown, e.g. by iterating over matching elements!");
        }
    }

    @Test
    public void testHasNextWithAdvancing() {
        for (int i = 0; i < 3; i++) {
            assertTrue("PredicateIterator.hasNext() should return true when there is a next matching element!",
                    preditsw.hasNext());
            preditsw.next();
        }

        assertFalse(
                "PredicateIterator.hasNext() should return false after the last matching element of the data structure has been provided!",
                preditsw.hasNext());
    }

    @Test
    public void testNoElementsToProvide() {
        testList = new LinkedList<>();
        testList.add("West1");
        testList.add("nonevalid");
        testList.add("nonevalid");
        testList.add("nonevalid");
        testList.add("West");
        testList.add("East2");
        preditsw = new PredicateIterator<>(testList.iterator(), new PredicateStartsWith<>(), "T");

        assertFalse("PredicateIterator.hasNext() should return false if there is no matching element at all.",
                preditsw.hasNext());
        try {
            preditsw.next();
            fail("PredicateIterator.next() should throw a NoSuchElementException if there is no matching element at all.");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void testRemove() {
        try {
            preditsw.remove();
            fail("PredicateIterator.remove() should thrown an UnsupportedOperationException!");
        } catch(UnsupportedOperationException e) {
        }
    }

}
