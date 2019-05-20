import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class LibraryEmptyTest {
    private Library lib;

    @Before
    public void setUp() {
        lib = new Library();
    }

    @Test
    public void testInsertBook() {
        List<Book> books = new ArrayList<Book>();

        for (int i = 0; i < 5; i++) {
            books.add(new Book("" + i));
            assertTrue("Library.insertBook() should return true if the specified Book is added to the Library!",
                    lib.insertBook(books.get(i)));
            assertSame("Library.insertBook() should actually add the specified Book!", books.get(i),
                    lib.searchForIsbn(books.get(i).getIsbn()));
            for (int j = 0; j <= i; j++) {
                assertFalse(
                        "Library.insertBook() should return false if the Library already contains the specified Book!",
                        lib.insertBook(books.get(i)));
            }
        }
    }

    @Test
    public void testSearchForIsbn() {
        assertNull("Library.searchForIsbn() should return null if the Library is empty!", lib.searchForIsbn("0"));
    }

    @Test
    public void testSearchForAuthor() {
        assertTrue("Library.searchForAuthor() should return an empty Collection if the Library is empty!", lib
                .searchForAuthor("anyone").isEmpty());
    }

    @Test
    public void testLibraryStockType() {
        try {
            assertEquals("Library.stock should be a Set!", Set.class, lib.getClass().getDeclaredField("stock")
                    .getType());
        } catch (NoSuchFieldException nsfe) {
            fail("The class Library should have an attribute named stock!");
        }
    }

    @Test
    public void testListStockByAuthor() {
        Map<String, Set<Book>> stock = lib.listStockByAuthor();
        assertTrue("Library.listStockByAuthor() should return an empty Map if the Library is empty!", stock != null
                && stock.isEmpty());
    }
}
