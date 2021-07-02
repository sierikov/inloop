import static org.junit.Assert.assertFalse;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class EmptyListPredicateIteratorTest {
    private final List<String> emptyList = List.of();
    private Iterator<String> emptyListIterator;

    @Before
    public void setUp() {
        emptyListIterator = new PredicateIterator<String>(emptyList.iterator(), new HasLength(2));
    }

    @Test
    public void iterHasNextShouldReturnFalse() {
        assertFalse(emptyListIterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterNextShouldThrowNoSuchElementException() {
        emptyListIterator.next();
    }
}
