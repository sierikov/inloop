import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class LibraryFilledTest {
    private Library lib;

    private Book b0;
    private Book b1;
    private Book b2;
    private Book b3;
    private Book b4;

    @Before
    public void setUp() {
        b0 = new Book("0", "a0", "t0");
        b1 = new Book("1", "a1", "t1");
        b2 = new Book("2", "a2", "t2");
        b3 = new Book("3", "a3", "t3");
        b4 = new Book("4", "a2", "t4");

        lib = new Library();
        lib.insertBook(b3);
        lib.insertBook(b4);
        lib.insertBook(b0);
        lib.insertBook(b2);
        lib.insertBook(b1);
    }

    @Test
    public void testSearchForISBN() {
        assertEquals("Library.searchForIsbn() should return the correct Book!", b0, lib.searchForIsbn("0"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b1, lib.searchForIsbn("1"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b2, lib.searchForIsbn("2"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b3, lib.searchForIsbn("3"));
        assertEquals("Library.searchForIsbn() should return the correct Book!", b4, lib.searchForIsbn("4"));
        assertNull("Library.searchForIsbn() should return null if there is no Book with the specified ISBN!",
                lib.searchForIsbn("5"));
    }

    @Test
    public void testSearchForAuthor() {
        Collection<Book> test = lib.searchForAuthor("a0");
        assertTrue("Library.searchForAuthor() should return all of the given author's books!", test.contains(b0));
        assertEquals("Library.searchForAuthor() should not return any more than the books of the given author!", 1,
                test.size());

        test = lib.searchForAuthor("a1");
        assertTrue("Library.searchForAuthor() should return all of the given author's books!", test.contains(b1));
        assertEquals("Library.searchForAuthor() should not return any more than the books of the given author!", 1,
                test.size());

        test = lib.searchForAuthor("a2");
        assertTrue("Library.searchForAuthor() should return all of the given author's books!", test.contains(b2));
        assertTrue("Library.searchForAuthor() should return all of the given author's books!", test.contains(b4));
        assertEquals("Library.searchForAuthor() should not return any more than the books of the given author!", 2,
                test.size());

        test = lib.searchForAuthor("a3");
        assertTrue("Library.searchForAuthor() should return all of the given author's books!", test.contains(b3));
        assertEquals("Library.searchForAuthor() should not return any more than the books of the given author!", 1,
                test.size());

        test = lib.searchForAuthor("a5");
        assertNotNull(
                "Library.searchForAuthor() should not return null if the Library does not contain any book of the given author!",
                test);
        assertTrue(
                "Library.searchForAuthor() should return an empty Collection if the Library does not contain any book of the given author!",
                test.isEmpty());
    }

    @Test
    public void testListStockByAuthor() {
        Map<String, Set<Book>> listing = lib.listStockByAuthor();
        assertNotNull("Library.listStockByAuthor() should not return null!", listing);
        assertEquals(
                "The Map returned by Library.listStockByAuthor() should have as many entries as there are authors known to the Library!",
                4, listing.size());
        assertTrue(
                "The Map returned by Library.listStockByAuthor() should have one entry for every author known to the Library!",
                listing.keySet().contains("a0"));
        assertTrue(
                "The Map returned by Library.listStockByAuthor() should have one entry for every author known to the Library!",
                listing.keySet().contains("a1"));
        assertTrue(
                "The Map returned by Library.listStockByAuthor() should have one entry for every author known to the Library!",
                listing.keySet().contains("a2"));
        assertTrue(
                "The Map returned by Library.listStockByAuthor() should have one entry for every author known to the Library!",
                listing.keySet().contains("a3"));

        Set<Book> books = listing.get("a0");
        assertTrue(
                "The Map returned by Library.listStockByAuthor() should map an author's name to all of the author's books!",
                books.contains(b0));
        assertEquals(
                "The Map returned by Library.listStockByAuthor() should not map an author's name to books that are not by the author!",
                1, books.size());

        books = listing.get("a1");
        assertTrue(
                "The Map returned by Library.listStockByAuthor() should map an author's name to all of the author's books!",
                books.contains(b1));
        assertEquals(
                "The Map returned by Library.listStockByAuthor() should not map an author's name to books that are not by the author!",
                1, books.size());

        books = listing.get("a2");
        assertTrue(
                "The Map returned by Library.listStockByAuthor() should map an author's name to all of the author's books!",
                books.contains(b2));
        assertTrue(
                "The Map returned by Library.listStockByAuthor() should map an author's name to all of the author's books!",
                books.contains(b4));
        assertEquals(
                "The Map returned by Library.listStockByAuthor() should not map an author's name to books that are not by the author!",
                2, books.size());

        books = listing.get("a3");
        assertTrue(
                "The Map returned by Library.listStockByAuthor() should map an author's name to all of the author's books!",
                books.contains(b3));
        assertEquals(
                "The Map returned by Library.listStockByAuthor() should not map an author's name to books that are not by the author!",
                1, books.size());
    }
}
