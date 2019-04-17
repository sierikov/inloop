import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(backOut);
        System.setErr(backErr);
    }

    private void testStreams(String message, String streamOutput) {
        assertEquals(message, streamOutput + System.lineSeparator(), outContent.toString());
        assertEquals("Your program should not print into the error stream (System.err)!", "", errContent.toString());
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
