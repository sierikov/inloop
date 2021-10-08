import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
	private Book book1;
	private Book book2;
	private Book book3;

	@Before
	public void setUp() {
		book1 = new Book("123-1-11", "Some Author", "Some Title");
		book2 = new Book("123-1-12", "Another Author", "Another Title");
		book3 = new Book("123-1-13");
	}

    @Test
    public void bookImplementsComparable() {
        assertTrue("Book must implement Comparable!", book1 instanceof Comparable);
    }

	@Test
	public void compareToSelfShouldReturnZero() {
		String message = "Book.compareTo(…) should recognise it as equal if a Book is compared to itself!";
		assertEquals(message, 0, book1.compareTo(book1));
		assertEquals(message, 0, book2.compareTo(book2));
		assertEquals(message, 0, book3.compareTo(book3));
	}

	@Test
	public void compareToLowerIsbnShouldBeNegative() {
		String message = "Book.compareTo(…) should consider a Book with a lower ISBN less than a Book with a higher ISBN!";
		assertTrue(message, book1.compareTo(book2) < 0);
		assertTrue(message, book1.compareTo(book3) < 0);
		assertTrue(message, book2.compareTo(book3) < 0);
	}

	@Test
	public void compareToHigherIsbnShouldBePositive() {
		String message = "Book.compareTo(…) should consider a Book with a higher ISBN greater than a Book with a lower ISBN!";
		assertTrue(message, book2.compareTo(book1) > 0);
		assertTrue(message, book3.compareTo(book1) > 0);
		assertTrue(message, book3.compareTo(book2) > 0);
	}

	@Test
	public void compareToWithSameIsbnShouldBeZero() {
		String message = "Book.compareTo(…) should recognize Books with the same ISBN as equal!";
		assertEquals(message, 0, book1.compareTo(new Book("123-1-11")));
		assertEquals(message, 0, book2.compareTo(new Book("123-1-12")));
	}

	@Test
	public void compareToWithSameIsbnShouldBeZeroIgnoringOtherValues() {
		String message = "Book.compareTo(…) should compare Books using their ISBN only!";
		assertEquals(message, 0, book1.compareTo(new Book("123-1-11", "some value", "some value")));
		assertEquals(message, 0, book2.compareTo(new Book("123-1-12", "some value", "some value")));
	}

	@Test
	public void getIsbnShouldReturnIsbn() {
		String message = "Book.getIsbn() should return the ISBN of a book properly!";
		assertEquals(message, "123-1-11", book1.getIsbn());
		assertEquals(message, "123-1-12", book2.getIsbn());
		assertEquals(message, "123-1-13", book3.getIsbn());
	}

	@Test
	public void getAuthorShouldReturnAuthor() {
		String message = "Book.getAuthor() should return the author of a book properly!";
		assertEquals(message, "Some Author", book1.getAuthor());
		assertEquals(message, "Another Author", book2.getAuthor());
	}

	@Test
	public void getAuthorShouldReturnEmptyString() {
		assertEquals(
				"Book.getAuthor() should return an empty String if the Book has been instantiated with the ISBN-only constructor!",
				"", book3.getAuthor());
	}

	@Test
	public void getTitleShouldReturnTitle() {
		String message = "Book.getTitle() should return the title of a book properly!";
		assertEquals(message, "Some Title", book1.getTitle());
		assertEquals(message, "Another Title", book2.getTitle());
	}

	@Test
	public void getTitleShouldReturnEmptyString() {
		assertEquals(
				"Book.getTitle() should return an empty String if the Book has been instantiated with the ISBN-only constructor!",
				"", book3.getTitle());
	}
}
