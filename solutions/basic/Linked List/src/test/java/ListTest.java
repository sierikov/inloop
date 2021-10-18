import static java.lang.reflect.Modifier.isPrivate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ListTest {
    private List list;

    @Before
    public void setUp() {
        list = new List();
    }

    // experimental structure check
    @Test
    public void hasListElementAttribute() {
        for (var field : List.class.getDeclaredFields()) {
            if (ListElement.class.equals(field.getType()) && isPrivate(field.getModifiers())) {
                return;
            }
        }
        fail("List should have a private attribute of type ListElement.");
    }

    @Test
    public void testAppendNullArgument() {
        try {
            list.append(null);
        } catch (IllegalArgumentException e) {
            return;
        } catch (NullPointerException e) {
            // fallthrough
        }
        fail("List.append() should throw an IllegalArgumentException if the argument is null!");
    }

    @Test
    public void testAppendEmptyString() {
        try {
            // new String() catches broken String comparisons
            list.append(new String(""));
            fail("List.append() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testAppendOneElement() {
        list.append("some content");
    }

    @Test
    public void testAppendTwoElements() {
        list.append("some content");
        list.append("more content");
    }

    @Test
    public void testAppendManyElements() {
        for (int i = 0; i < 20; i++) {
            list.append("element " + i);
        }
    }

    @Test
    public void testRemoveNullArgument() {
        try {
            list.remove(null);
        } catch (IllegalArgumentException e) {
            return;
        } catch (NullPointerException e) {
            // fallthrough
        }
        fail("List.remove() should throw an IllegalArgumentException if the argument is null!");
    }

    @Test
    public void testRemoveEmptyString() {
        try {
            // new String() catches broken String comparisons
            list.remove(new String(""));
            fail("List.remove() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    private void appendTestElements() {
        String[] elements = new String[] { "1", "3", "4", "3", "5" };
        for (String element : elements) {
            list.append(element);
        }
    }

    @Test
    public void testRemoveReturnNullOnEmptyList() {
        assertNull("List.remove() should return null if the list is empty!",
                list.remove("removeMe"));
    }

    @Test
    public void testRemoveReturnNull() {
        appendTestElements();
        assertNull(
                "List.remove() should return null if the List contains no element with a given content!",
                list.remove("removeMe"));
    }

    @Test
    public void testRemoveReturnContentOnSuccess() {
        appendTestElements();
        assertEquals("List.remove() should return the removed element's content.", "3",
                list.remove("3"));
    }

    @Test
    public void testRemoveRemovesOnlyOneOccurrence() {
        appendTestElements();
        list.remove("3");
        assertEquals("List.remove() should only remove one occurrence of a given content!", "3",
                list.remove("3"));
        assertNull("Also, List.remove() should then actually remove the element!",
                list.remove("3"));
    }

    @Test
    public void testRemoveLastElement() {
        list.append("1");
        assertEquals(
                "List.remove() should return the removed element's content. Having only one "
                        + "element in the list might need to be regarded as a special case!",
                "1", list.remove("1"));
        assertNull(
                "List.remove() should return null if the last element was removed! If you've "
                        + "made it to this message, make sure you actually remove items.",
                list.remove("1"));
    }
}
