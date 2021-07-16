import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

// Checking-code for io-streams is from:
// https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

public class BookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private PrintStream backOut, backErr;

    @Before
    public void setUpStreams() {
        backOut = System.out;
        backErr = System.err;

        try {
            System.setOut(new PrintStream(outContent, false, "UTF-8"));
            System.setErr(new PrintStream(errContent, false, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new UncheckedIOException("UTF-8 is not supported.", e);
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(backOut);
        System.setErr(backErr);
    }

    private void testStreams(String message, String streamOutput) {
        try {
            assertEquals(message, streamOutput + System.lineSeparator(), outContent.toString("UTF-8"));
            assertEquals("Your program should not print into the error stream (System.err)!", "", errContent.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new UncheckedIOException("UTF-8 is not supported.", e);
        }
    }

    @Test
    public void testInstantiation() {
        try {
            Book book = new Book("Java");
            testStreams("The constructor of the class Book should print the correct message!", "Book Java created.");
            assertNotNull("The constructor of the class Book did not create a new Book instance correctly!", book);
        }
        // exception handling
        catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            fail("The constructor of the class Book produced the following error. Fix it in order to pass the test!\n"
                    + errors.toString());
        }
    }

    @Test
    public void testToString() {
        Book book = new Book("Java");
        assertEquals("Book.toString() should return the title of the book properly!", "Java", book.toString());
    }
}
