import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LibraryEmptyTest {
    private Library lib;

    @Before
    public void setUp() {
        lib = new Library();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testSortedInsertion() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
            SecurityException {
        List<Book> stock;
        List<Book> books = new ArrayList<>();
        int[] insertionOrder = new int[] { 4, 2, 0, 3, 1 };

        Field f = lib.getClass().getDeclaredField("stock");
        f.setAccessible(true);
        stock = (List<Book>) f.get(lib);

        for (int i = 0; i < books.size(); i++) {
            books.add(new Book("" + insertionOrder[i]));
            lib.sortedInsertion(books.get(i));
            assertTrue("Library.sortedInsertion() should actually add the specified Book!",
                    stock.contains(books.get(i)));

            Collections.sort(books);
            for (int j = 0; j < i + 1; j++) {
                assertTrue(
                        "Library.sortedInsertion() should ensure that the Book objects in Library.stock are sorted!",
                        books.get(j) == stock.get(j));
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
            assertEquals("Library.stock should be a List!", List.class, lib.getClass().getDeclaredField("stock")
                    .getType());
        } catch (NoSuchFieldException nsfe) {
            fail("The class Library should have an attribute named stock!");
        }
    }
}
