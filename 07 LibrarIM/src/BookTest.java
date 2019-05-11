import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
    private Book b1;
    private Book b2;
    private Book b3;

    @Before
    public void setUp() {
        b1 = new Book("0", "nobody", "mine");
        b2 = new Book("1", "I", "none");
        b3 = new Book("2");
    }

    @Test
    public void testCompareTo() {
        assertEquals("Book.compareTo() should recognise it as equal if a Book is compared to itself!", 0,
                b1.compareTo(b1));
        assertEquals("Book.compareTo() should recognise it as equal if a Book is compared to itself!", 0,
                b2.compareTo(b2));
        assertEquals("Book.compareTo() should recognise it as equal if a Book is compared to itself!", 0,
                b3.compareTo(b3));

        assertTrue("Book.compareTo() should consider a Book with a lower ISBN less than a Book with a higher ISBN!",
                b1.compareTo(b2) < 0);
        assertTrue("Book.compareTo() should consider a Book with a lower ISBN less than a Book with a higher ISBN!",
                b1.compareTo(b3) < 0);
        assertTrue("Book.compareTo() should consider a Book with a lower ISBN less than a Book with a higher ISBN!",
                b2.compareTo(b3) < 0);

        assertTrue(
                "Book.compareTo() should consider a Book with a higher ISBN greater than a Book with a lower ISBN!",
                b2.compareTo(b1) > 0);
        assertTrue(
                "Book.compareTo() should consider a Book with a higher ISBN greater than a Book with a lower ISBN!",
                b3.compareTo(b1) > 0);
        assertTrue(
                "Book.compareTo() should consider a Book with a higher ISBN greater than a Book with a lower ISBN!",
                b3.compareTo(b2) > 0);
    }

    @Test
    public void testGetIsbn() {
        assertEquals("Book.getIsbn() should return the ISBN of a book properly!", "0", b1.getIsbn());
        assertEquals("Book.getIsbn() should return the ISBN of a book properly!", "1", b2.getIsbn());
        assertEquals("Book.getIsbn() should return the ISBN of a book properly!", "2", b3.getIsbn());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Book.getAuthor() should return the author of a book properly!", "nobody", b1.getAuthor());
        assertEquals("Book.getAuthor() should return the author of a book properly!", "I", b2.getAuthor());
        assertEquals(
                "Book.getAuthor() should return an empty String if the Book has been instantiated with the ISBN-only constructor!",
                "", b3.getAuthor());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Book.getTitle() should return the title of a book properly!", "mine", b1.getTitle());
        assertEquals("Book.getTitle() should return the title of a book properly!", "none", b2.getTitle());
        assertEquals(
                "Book.getTitle() should return an empty String if the Book has been instantiated with the ISBN-only constructor!",
                "", b3.getTitle());
    }
}
