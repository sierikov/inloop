import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class LibraryFilledTest {
    private Library lib;

    private Book b0;
    private Book b1;
    private Book b2;
    private Book b3;
    private Book b4;
    private Book b6;
    private Book b9;

    @Before
    public void setUp() {
        b0 = new Book("0", "a0", "t0");
        b1 = new Book("1", "a1", "t1");
        b2 = new Book("2", "a2", "t2");
        b3 = new Book("3", "a3", "t3");
        b4 = new Book("4", "a2", "t4");
        b6 = new Book("6", "a6", "t6");
        b9 = new Book("9", "a9", "t9");

        lib = new Library();
        lib.sortedInsertion(b2);
        lib.sortedInsertion(b3);
        lib.sortedInsertion(b0);
        lib.sortedInsertion(b6);
        lib.sortedInsertion(b4);
        lib.sortedInsertion(b9);
        lib.sortedInsertion(b1);

    }

    @Test
    public void testSearchForISBN() {
        assertEquals("Library.searchForIsbn() should return the correct Book!", b0, lib.searchForIsbn("0"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b1, lib.searchForIsbn("1"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b2, lib.searchForIsbn("2"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b3, lib.searchForIsbn("3"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b4, lib.searchForIsbn("4"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b6, lib.searchForIsbn("6"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b9, lib.searchForIsbn("9"));
        assertNull("Library.searchForIsbn() should return null if there is no Book with the specified ISBN!",
                lib.searchForIsbn("5"));
    }

    @Test
    public void testCorrect() {
        assertEquals("Library.searchForIsbn() should return the correct Book!", b0, lib.searchForIsbn("0"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b1, lib.searchForIsbn("1"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b6, lib.searchForIsbn("6"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b9, lib.searchForIsbn("9"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b4, lib.searchForIsbn("4"));
    }

    @Test
    public void testSearchForAuthor() {
        Collection<Book> searchResult = lib.searchForAuthor("a0");
        assertTrue("Library.searchForAuthor() does not return all of the given author's books!",
                searchResult.contains(b0));
        assertEquals("Library.searchForAuthor() should not return any more than the books of the given author!", 1,
                searchResult.size());

        searchResult = lib.searchForAuthor("a1");
        assertTrue("Library.searchForAuthor() does not return all of the given author's books!",
                searchResult.contains(b1));
        assertEquals("Library.searchForAuthor() should not return any more than the books of the given author!", 1,
                searchResult.size());

        searchResult = lib.searchForAuthor("a2");
        assertTrue("Library.searchForAuthor() does not return all of the given author's books!",
                searchResult.contains(b2));
        assertTrue("Library.searchForAuthor() does not return all of the given author's books!",
                searchResult.contains(b4));
        assertEquals("Library.searchForAuthor() should not return any more than the books of the given author!", 2,
                searchResult.size());

        searchResult = lib.searchForAuthor("a3");
        assertTrue("Library.searchForAuthor() does not return all of the given author's books!",
                searchResult.contains(b3));
        assertEquals("Library.searchForAuthor() should not return any more than the books of the given author!", 1,
                searchResult.size());

        searchResult = lib.searchForAuthor("a5");
        assertNotNull(
                "Library.searchForAuthor() should not return null if the Library does not contain any book of the given author!",
                searchResult);
        assertTrue(
                "Library.searchForAuthor() should return an empty Collection if the Library does not contain any book of the given author!",
                searchResult.isEmpty());
    }
}
