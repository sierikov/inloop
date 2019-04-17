import static org.junit.Assert.assertEquals;
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

public class LibTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private PrintStream backOut, backErr;

    private Library lib;
    private Book book;

    @Before
    public void setUpStreams() {
        backOut = System.out;
        backErr = System.err;

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        lib = new Library();
        book = new Book("Java");
        resetStreams();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(backOut);
        System.setErr(backErr);
    }

    private void resetStreams() {
        outContent.reset();
        errContent.reset();
    }

    // A method comparing the String streamOutput with the actual streams
    private void testStreams(String message, String streamOutput) {
        assertEquals(message, streamOutput + System.lineSeparator(), outContent.toString());
        assertEquals("Your program should not print into the error stream (System.err)!", "", errContent.toString());
    }

    @Test
    public void testConstructorMessage() {
        try {
            new Library();
            testStreams("Library.Library() should print the correct message!",
                    "Hello, I am a library, which can store up to 10 books!");
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            fail("Library.Library() produced the following error. Fix it in order to pass the test!\n" + errors.toString());
        }
    }

    @Test
    public void testAdd() {
        try {
            for (int i = 0; i < 10; i++) {
                lib.add(book);
                testStreams(
                        "Library.add() should accept up to 10 books and print the correct message! It must be possible to add the same book multiple times.",
                        "I added the book Java!");
                resetStreams();
            }
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            fail("Library.add() produced the following error. Fix it in order to pass the test!\n" + errors.toString());
        }
    }

    @Test
    public void testAddMoreThanTenBooks() {
        try {
            for (int i = 0; i < 10; i++) {
                lib.add(book);
            }
            resetStreams();

            lib.add(book);
            testStreams(
                    "Library.add() should not accept more than 10 books and print the correct message if called another time!",
                    "The library is full!");
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            fail("Library.add() produced the following error. Fix it in order to pass the test!\n" + errors.toString());
        }
    }

    @Test
    public void testSearchSuccessful() {
        try {
            lib.add(book);
            resetStreams();

            assertEquals("Library.search() should return the Book object with the given title!", book,
                    lib.search("Java"));
            testStreams("Library.search() should print the correct message if a book can be found!",
                    "The book with the title Java exists in the library!");
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            fail("Library.search() produced the following error. Fix it in order to pass the test!\n"
                    + errors.toString());
        }
    }

    @Test
    public void testSearchUnsuccessful() {
        try {
            assertEquals("Library.search() must return null if the given title cannot be found!", null,
                    lib.search("J"));
            testStreams("Library.search() should print the correct message if a book cannot be found!",
                    "The book with the title J does not exist in the library!");
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            fail("Library.search() produced the following error. Fix it in order to pass the test!\n"
                    + errors.toString());
        }
    }
}
