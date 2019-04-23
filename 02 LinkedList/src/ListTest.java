import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

public class ListTest {
    private List l;

    @Before
    public void setUp() {
        l = new List();
    }

    @Test
    public void testAppendNullArgument() {
        try {
            l.append(null);
            fail("List.append() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAppendIllegalArgument() {
        try {
            l.append("");
            fail("List.append() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testAppend() {
        try {
            for (int i = 0; i < 20; i++) {
                l.append(String.valueOf(i));
            }
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            fail("List.append() produced the following error. Fix it in order to pass the test!\n" + errors.toString());
        }
    }

    @Test
    public void testRemoveNullArgument() {
        try {
            assertNull("List.remove() should return null if the List did not contain the given String!",
                    l.remove(null));
        } catch (NullPointerException e) {
            fail("List.remove() should not throw a NullPointerException if the argument is null because it does not require a non-null argument!");
        }
    }

    @Test
    public void testRemoveEmptyArgument() {
        try {
            assertNull("List.remove() should return null if the List did not contain the given String!", l.remove(""));
        } catch (NullPointerException e) {
            fail("List.remove() should not throw a NullPointerException if the argument is null because it does not require a non-null argument!");
        }
    }

    @Test
    public void testRemove() {
        assertNull("List.remove() should return null if the List did not contain the given String!", l.remove("test"));
        String[] values = new String[] { "1", "2", "3", "4", "3", "5", "6" };
        String result;
        for (int i = 0; i < values.length; i++) {
            l.append(values[i]);
        }
        System.out.println(l);
        /* 1 -> 2 -> 3 -> 4 -> 3 -> 5 -> 6 */
        assertNull("List.remove() should return null if the List did not contain the given String!", l.remove("test"));
        System.out.println(l);
        /* 1 -> 2 -> 3 -> 4 -> 3 -> 5 -> 6 */
        assertEquals("List.remove() should return the content of the element that has been removed!", "3",
                l.remove("3"));
        System.out.println(l);
        /* 1 -> 2 -> 4 -> 3 -> 5 -> 6 */
        result = l.remove("3");
        /* 1 -> 2 -> 4 -> 5 -> 6 */
        System.out.println(l);
        Objects.requireNonNull(result, "List.remove() should only remove the first occurrence of a String from the list!");
        System.out.println(l);
        assertEquals("List.remove() should return the content of the element that has been removed!", "3", result);
        System.out.println(l);
        assertNull(
                "List.remove() should return null if all occurrences of the given String have been removed previously!",
                l.remove("3"));
        /* 1 -> 2 -> 4 -> 5 -> 6 */
        /* Remove second last element */
        assertEquals("List.remove() should return the content of the element that has been removed!", "5",
                l.remove("5"));
        /* 1 -> 2 -> 4 -> 6 */
        assertNull(
                "List.remove() should return null if all occurrences of the given String have been removed previously!",
                l.remove("5"));
        /* 1 -> 2 -> 4 -> 6 */
        /* Remove last element */
        assertEquals("List.remove() should return the content of the element that has been removed!", "6",
                l.remove("6"));
        /* 1 -> 2 -> 4 */
        assertNull(
                "List.remove() should return null if all occurrences of the given String have been removed previously!",
                l.remove("6"));
        /* 1 -> 2 -> 4 */
        /* Remove second element */
        assertEquals("List.remove() should return the content of the element that has been removed!", "2",
                l.remove("2"));
        /* 1 -> 4 */
        assertNull(
                "List.remove() should return null if all occurrences of the given String have been removed previously!",
                l.remove("2"));
        System.out.println(l);
        /* 1 -> 4 */
        /* Remove first element */
        assertEquals("List.remove() should return the content of the element that has been removed!", "1",
                l.remove("1"));
        System.out.println(l);
        /* 4 */
        assertNull(
                "List.remove() should return null if all occurrences of the given String have been removed previously!",
                l.remove("1"));
        /* 4 */
        /* Remove only element in the list */
        System.out.println(l);
        assertEquals(
                "List.remove() should return the content of the element that has been removed! Mind the case where this element is the only one in the entire list!",
                "4", l.remove("4"));
        System.out.println(l);
        /* null */
        assertNull(
                "List.remove() should return null if all occurrences of the given String have been removed previously!",
                l.remove("4"));
        /* null */
    }
}
