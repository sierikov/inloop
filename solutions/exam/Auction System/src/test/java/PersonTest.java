import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() {
        person = new Person("Max");
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            person = new Person(null);
            fail("Person.Person() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            person = new Person("");
            fail("Person.Person() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetName() {
        assertEquals("Person.getName() should return the correct value!", "Max", person.getName());
    }

    @Test
    public void testToString() {
        assertEquals("Person.toString() should return the correct value!", "Max", person.toString());
    }
}
