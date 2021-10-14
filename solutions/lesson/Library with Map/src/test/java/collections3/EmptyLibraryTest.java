package collections3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class EmptyLibraryTest {
    private Library library;
    private Book book;

    @Before
    public void setUp() {
        book = new Book("123-1-11", "Some Author", "Some Title");
        library = new Library();
    }

    @Test
    public void shouldBeEmpty() {
        assertEquals("A new library shouldn't contain any books!", 0, library.getStock().size());
    }

    @Test
    public void insertBookOnceReturnsTrue() {
        assertTrue("Library.insertBook(…) should return true!", library.insertBook(book));
    }

    @Test
    public void insertBookTwiceReturnsFalse() {
        library.insertBook(book);
        assertFalse("Library.insertBook(…) of a book already in the stock should return false!",
                library.insertBook(book));
    }

    @Test
    public void searchForIsbnReturnsNull() {
        assertNull("Library.searchForIsbn(…) should return null if the Library is empty!",
                library.searchForIsbn("123-1-11"));
    }

    @Test
    public void searchForAuthorReturnsEmptyCollection() {
        assertTrue(
                "Library.searchForAuthor() should return an empty Collection if the Library is empty!",
                library.searchForAuthor("Some Author").isEmpty());
    }

    @Test
    public void listStockByAuthorReturnsEmptyMap() {
        assertEquals(
                "Library.listStockbyAuthor() should return an empty Map if the Library is empty!",
                Map.of(), library.listStockByAuthor());
    }
}
