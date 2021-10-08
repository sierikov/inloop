import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class FilledLibraryTest {
    private Library library;

    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;

    @Before
    public void setUp() {
        library = new Library();
        book1 = new Book("123-1-11", "Author A", "Title 1");
        book2 = new Book("123-1-12", "Author B", "Title 2");
        book3 = new Book("123-1-13", "Author C", "Title 3");
        book4 = new Book("123-1-14", "Author D", "Title 4");
        book5 = new Book("123-1-15", "Author C", "Title 5");
        library.insertBook(book4);
        library.insertBook(book5);
        library.insertBook(book1);
        library.insertBook(book3);
        library.insertBook(book2);
    }

    @Test
    public void searchForIsbnReturnsCorrectBook() {
        assertSame("Library.searchForIsbn(…) should return the correct Book!", book1, library.searchForIsbn("123-1-11"));
        assertSame("Library.searchForIsbn(…) should return the correct Book!", book2, library.searchForIsbn("123-1-12"));
        assertSame("Library.searchForIsbn(…) should return the correct Book!", book3, library.searchForIsbn("123-1-13"));
        assertSame("Library.searchForIsbn(…) should return the correct Book!", book4, library.searchForIsbn("123-1-14"));
        assertSame("Library.searchForIsbn(…) should return the correct Book!", book5, library.searchForIsbn("123-1-15"));
    }

    @Test
    public void searchForIsbnReturnsNullIfNotFound() {
        assertNull("Library.searchForIsbn(…) should return null if there is no Book with the specified ISBN!",
                library.searchForIsbn("5"));
    }

    @Test
    public void searchForAuthorReturnsExactOneBook() {
        Collection<Book> searchResult = library.searchForAuthor("Author D");
        assertTrue("Library.searchForAuthor(…) does not return all of the given author's books!",
                searchResult.contains(book4));
        assertEquals("Library.searchForAuthor(…) should only return the books of the given author!", 1,
                searchResult.size());
    }

    @Test
    public void searchForAuthorReturnsMultipleBooks() {
        Collection<Book> searchResult = library.searchForAuthor("Author C");
        String message = "Library.searchForAuthor(…) does not return all of the given author's books!";
        assertTrue(message, searchResult.contains(book3));
        assertTrue(message, searchResult.contains(book5));
        assertEquals("Library.searchForAuthor(…) should only return the books of the given author!", 2,
                searchResult.size());
    }

    @Test
    public void searchForAuthorReturnsEmptyCollectionIfNotFound() {
    	Collection<Book> searchResult = library.searchForAuthor("Author");
        assertTrue(
                "Library.searchForAuthor(…) should return an empty Collection if the Library does not contain any book of the given author!",
                searchResult.isEmpty());
    }
}
