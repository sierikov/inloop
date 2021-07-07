import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BidTest {
    private Bid bid;
    private Person person;

    @Before
    public void setUp() {
        person = new Person("Max");
        bid = new Bid(person, 10);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            bid = new Bid(null, 1);
            fail("Bid.Bid() should throw a NullPointerException if the person argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            bid = new Bid(person, 0);
            fail("Bid.Bid() should throw an IllegalArgumentException if the price argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            bid = new Bid(person, -1);
            fail("Bid.Bid() should throw an IllegalArgumentException if the price argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetBidder() {
        assertEquals("Bid.getBidder() should return the correct value!", person, bid.getBidder());
    }

    @Test
    public void testGetPrice() {
        assertEquals("Bid.getPrice() should return the correct value!", 10, bid.getPrice());
    }

    @Test
    public void testToString() {
        assertEquals("Bid.toString() should return the correct value!", "10 EUR by Max", bid.toString());
    }
}
