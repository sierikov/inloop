package collections1;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class EmptyLibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void insertBookReturnsTrue() {
        assertTrue("Library.insertBook(…) should return true!", library.insertBook(new Book("123-1-11")));
    }

    @Test
    public void searchForIsbnReturnsNull() {
        assertNull("Library.searchForIsbn(…) should return null if the Library is empty!",
                library.searchForIsbn("123-1-11"));
    }

    @Test
    public void searchForAuthorReturnsEmptyCollection() {
        assertTrue("Library.searchForAuthor() should return an empty Collection if the Library is empty!",
                library.searchForAuthor("Some Author").isEmpty());
    }
}
