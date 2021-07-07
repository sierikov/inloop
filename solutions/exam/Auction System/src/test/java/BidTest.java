import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class BidTest {
    private Bid b;
    private Person p;

    @Before
    public void setUp() {
        p = new Person("Max");
        b = new Bid(p, 10);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            b = new Bid(null, 1);
            fail("Bid.Bid() should throw a NullPointerException if the person argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            b = new Bid(p, 0);
            fail("Bid.Bid() should throw an IllegalArgumentException if the price argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            b = new Bid(p, -1);
            fail("Bid.Bid() should throw an IllegalArgumentException if the price argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetBidder() {
        assertEquals("Bid.getBidder() should return the correct value!", p, b.getBidder());
    }

    @Test
    public void testGetPrice() {
        assertEquals("Bid.getPrice() should return the correct value!", 10, b.getPrice());
    }

    @Test
    public void testToString() {
        assertEquals("Bid.toString() should return the correct value!", "10 EUR by Max", b.toString());
    }
}
