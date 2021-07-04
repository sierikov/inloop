import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyMatrixTest {
    MyMatrix<String> filledMatrix, emptyMatrix;
    String a, b;

    @Before
    public void setUp() {
        filledMatrix = new MyMatrix<String>();
        emptyMatrix = new MyMatrix<String>();
        a = "a";
        b = "b";

        filledMatrix.put(0, 1, a);
        filledMatrix.put(1, 3, b);
        filledMatrix.put(2, 0, a);
    }

    @Test
    public void testGetRowCount() {
        assertEquals("MyMatrix.getRowCount() should return the current number of rows of the matrix!", 3,
                filledMatrix.getRowCount());
        filledMatrix.put(2, 0, "c");
        assertEquals("MyMatrix.getRowCount() should return the current number of rows of the matrix!", 3,
                filledMatrix.getRowCount());
        filledMatrix.put(3, 0, "c");
        assertEquals("MyMatrix.getRowCount() should return the current number of rows of the matrix!", 4,
                filledMatrix.getRowCount());
        filledMatrix.put(6, 0, "c");
        assertEquals("MyMatrix.getRowCount() should return the current number of rows of the matrix!", 7,
                filledMatrix.getRowCount());

        assertEquals("MyMatrix.getRowCount() should return the current number of rows of the matrix!", 0,
                emptyMatrix.getRowCount());
    }

    @Test
    public void testGetColumnCount() {
        assertEquals("MyMatrix.getColumnCount() should return the current number of columns of the matrix!", 4,
                filledMatrix.getColumnCount());
        filledMatrix.put(0, 3, "d");
        assertEquals("MyMatrix.getColumnCount() should return the current number of columns of the matrix!", 4,
                filledMatrix.getColumnCount());
        filledMatrix.put(0, 4, "d");
        assertEquals("MyMatrix.getColumnCount() should return the current number of columns of the matrix!", 5,
                filledMatrix.getColumnCount());
        filledMatrix.put(0, 7, "d");
        assertEquals("MyMatrix.getColumnCount() should return the current number of columns of the matrix!", 8,
                filledMatrix.getColumnCount());

        assertEquals("MyMatrix.getColumnCount() should return the current number of columns of the matrix!", 0,
                emptyMatrix.getColumnCount());
    }

    @Test
    public void testGetObjectCount() {
        assertEquals(
                "MyMatrix.getObjectCount() should return the number of objects which are currently stored in the matrix!",
                3, filledMatrix.getObjectCount());
        assertEquals(
                "MyMatrix.getObjectCount() should return the number of objects which are currently stored in the matrix!",
                0, emptyMatrix.getObjectCount());
    }

    @Test
    public void testGetDistinctObjectCount() {
        assertEquals(
                "MyMatrix.getDistinctObjectCount() should return the number of objects which are currently stored in the matrix but without counting the same object more than once!",
                2, filledMatrix.getDistinctObjectCount());
        assertEquals(
                "MyMatrix.getDistinctObjectCount() should return the number of objects which are currently stored in the matrix but without counting the same object more than once!",
                0, emptyMatrix.getDistinctObjectCount());
    }

    @Test
    public void testIterator() {
        String c = "c", d = "d";
        filledMatrix.put(4, 1, b);
        filledMatrix.put(0, 2, c);
        filledMatrix.put(2, 4, d);
        filledMatrix.put(2, 1, d);
        filledMatrix.put(1, 1, c);
        filledMatrix.put(3, 3, a);

        Iterator<String> iter = filledMatrix.iterator();
        assertEquals(
                "MyMatrix.iterator() should return an Iterator of type DepthFirstIterator which should be an inner class of MyMatrix!",
                "MyMatrix.DepthFirstIterator", iter.getClass().getCanonicalName());
        String[] values = {a, a, c, d, b, c, b, a, d};
        for (int i = 0; i < values.length; i++) {
            assertTrue("DepthFirstIterator.hasNext() should return true if there is a next available element!",
                    iter.hasNext());
            assertEquals("DepthFirstIterator.next() should return the correct next element if there is one available!",
                    values[i], iter.next());
        }
        assertFalse("DepthFirstIterator.hasNext() should return false if there is no next element!", iter.hasNext());
        try {
            iter.next();
            fail("DepthFirstIterator.next() should throw a NoSuchElementException if there is no next element!");
        } catch (NoSuchElementException e) {
        }

        try {
            iter.remove();
            fail("DepthFirstIterator.remove() should throw a UnsupportedOperationException upon being called!");
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testGetIllegalArgument() {
        for (int i = 3; i < 5; i++) {
            try {
                filledMatrix.get(i, 0);
                fail("MyMatrix.get() should throw an IllegalArgumentException if the given position is out of bounds!");
            } catch (IllegalArgumentException e) {
            }
        }
        for (int i = 4; i < 6; i++) {
            try {
                filledMatrix.get(0, i);
                fail("MyMatrix.get() should throw an IllegalArgumentException if the given position is out of bounds!");
            } catch (IllegalArgumentException e) {
            }
        }
        try {
            filledMatrix.get(-1, 0);
            fail("MyMatrix.get() should throw an IllegalArgumentException if the given row is negative!");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            filledMatrix.get(0, -1);
            fail("MyMatrix.get() should throw an IllegalArgumentException if the given column is negative!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i == 0 && j == 1) || (i == 2 && j == 0)) {
                    assertEquals("MyMatrix.get() should return the correct object at the given position!", a,
                            filledMatrix.get(i, j));
                } else {
                    if (i == 1 && j == 3) {
                        assertEquals("MyMatrix.get() should return the correct object at the given position!", b,
                                filledMatrix.get(i, j));
                    } else {
                        assertNull(
                                "MyMatrix.get() should return null of there is no object at the given position which is within the bounds!",
                                filledMatrix.get(i, j));
                    }
                }
            }
        }
    }

    @Test
    public void testPut() {
        assertEquals("MyMatrix.put() should return the old object if it is replaced by a new one!", a,
                filledMatrix.put(2, 0, b));
        assertEquals("MyMatrix.put() should return the old object if it is replaced by a new one!", b,
                filledMatrix.put(1, 3, a));
        assertNull("MyMatrix.put() should return null if no object has to be replaced!", emptyMatrix.put(0, 0, a));
        assertNull("MyMatrix.put() should return null if no object has to be replaced!", emptyMatrix.put(5, 5, null));
    }

    @Test
    public void testPutIllegalArgument() {
        try {
            filledMatrix.put(-1, 0, "negative row");
            fail("MyMatrix.put() should throw an IllegalArgumentException if the given row is negative!");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            filledMatrix.put(0, -1, "negative column");
            fail("MyMatrix.put() should throw an IllegalArgumentException if the given column is negative!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testContains() {
        assertTrue("MyMatrix.contains() should return true if the matrix contains the given object!",
                filledMatrix.contains(a));
        assertTrue("MyMatrix.contains() should return true if the matrix contains the given object!",
                filledMatrix.contains(b));
        assertFalse("MyMatrix.contains() should return false if the matrix does not contain the given object!",
                filledMatrix.contains("c"));
        assertFalse("MyMatrix.contains() should return false if the matrix does not contain the given object!",
                emptyMatrix.contains(a));
    }
}
