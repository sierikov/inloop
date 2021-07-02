import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class PredicateIteratorTest {
    private final List<String> values = List.of(//
            "Java and UML", "UML and Java", "Java 11", "UML 2.0", "Effective Java");
    private Iterator<String> valuesEndingWithJava;
    private Iterator<String> valuesBeginningWithJava;
    private Iterator<String> noValues;

    @Before
    public void setUp() {
        valuesEndingWithJava = new PredicateIterator<>(values.iterator(), new EndsWith("Java"));
        valuesBeginningWithJava = new PredicateIterator<>(values.iterator(), new StartsWith("Java"));
        noValues = new PredicateIterator<>(values.iterator(), new StartsWith("Doesn't match"));
    }

    @Test
    public void providesValuesEndingWithJava() {
        assertTrue(valuesEndingWithJava.hasNext());
        assertEquals("UML and Java", valuesEndingWithJava.next());
        assertTrue(valuesEndingWithJava.hasNext());
        assertEquals("Effective Java", valuesEndingWithJava.next());
    }

    @Test
    public void providesValuesBeginningWithJava() {
        assertTrue(valuesBeginningWithJava.hasNext());
        assertEquals("Java and UML", valuesBeginningWithJava.next());
        assertTrue(valuesBeginningWithJava.hasNext());
        assertEquals("Java 11", valuesBeginningWithJava.next());
    }

    @Test
    public void hasNextReturnsFalseAfterLastElement1() {
        valuesEndingWithJava.next();
        valuesEndingWithJava.next();
        assertFalse(valuesEndingWithJava.hasNext());
    }

    @Test
    public void hasNextReturnsFalseAfterLastElement2() {
        valuesBeginningWithJava.next();
        valuesBeginningWithJava.next();
        assertFalse(valuesBeginningWithJava.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextThrowsExceptionAfterLastElement1() {
        valuesEndingWithJava.next();
        valuesEndingWithJava.next();
        valuesEndingWithJava.next();  // should fail
    }

    @Test(expected = NoSuchElementException.class)
    public void nextThrowsExceptionAfterLastElement2() {
        valuesBeginningWithJava.next();
        valuesBeginningWithJava.next();
        valuesBeginningWithJava.next();  // should fail
    }

    @Test
    public void hasNextReturnsFalseIfNothingSatisfies() {
        assertFalse(noValues.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextThrowsExceptionIfNothingSatisfies() {
        noValues.next();
    }
}
