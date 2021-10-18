import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ListElementTest {
    private ListElement elem1;
    private ListElement elem2;

    @Before
    public void setUp() {
        elem1 = new ListElement("content1");
        elem2 = new ListElement("content2");
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new ListElement(null);
        } catch (IllegalArgumentException e) {
            return;
        } catch (NullPointerException e) {
            // fallthrough
        }
        fail("The ListElement constructor should throw an IllegalArgumentException if the argument is null!");
    }

    @Test
    public void testConstructorEmptyArgument() {
        try {
            // new String() catches broken String comparisons with == instead of equals(…)
            new ListElement(new String(""));
            fail("The ListElement constructor should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testConstructorAttributes() {
        assertEquals("The constructor of ListElement should set the content attribute correctly!", "content1",
                elem1.getContent());
        assertNull("A new ListElement's next attribute should contain null!", elem1.getNext());
        assertEquals("The constructor of ListElement should set the content attribute correctly!", "content2",
                elem2.getContent());
        assertNull("A new ListElement's next attribute should contain null!", elem2.getNext());
    }

    @Test
    public void testSetContentNullArgument() {
        try {
            elem1.setContent(null);
        } catch (IllegalArgumentException e) {
            return;
        } catch (NullPointerException e) {
            // fallthrough
        }
        fail("ListElement.setContent() should throw an IllegalArgumentException if the argument is null!");
    }

    @Test
    public void testSetEmptyContent() {
        try {
            // new String() catches broken String comparisons with == instead of equals(…)
            elem1.setContent(new String(""));
            fail("ListElement.setContent() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetSetContent() {
        elem1.setContent("anystring");
        assertEquals("ListElement.getContent() or ListElement.setContent() does not work properly!", "anystring",
                elem1.getContent());
    }

    @Test
    public void testGetSetNext() {
        elem1.setNext(elem2);
        assertSame("ListElement.getNext() or ListElement.setNext() does not work properly!", elem2, elem1.getNext());
    }

    @Test
    public void setNextNullShouldBePossible() {
        try {
            elem1.setNext(null);
        } catch (NullPointerException|IllegalArgumentException e) {
            fail("ListElement.setNext() should not throw an exception when given null as an argument.");
        }
    }
}
