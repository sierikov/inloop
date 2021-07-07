import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {
    private Bid bid;
    private Item item;
    private Person person1, person2, personNotHighestPrice;

    @Before
    public void setUp() {
        item = new Item("Blueprint", "A blueprint for building a touch screen", 5);
        person1 = new Person("Max");
        person2 = new Person("Moritz");
        personNotHighestPrice = new Person("Klaus");
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            item = new Item(null, "description", 5);
            fail("Item.Item() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }
        try {
            item = new Item("name", null, 5);
            fail("Item.Item() should throw a NullPointerException if the description argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorEmptyStringArgument() {
        try {
            item = new Item("", "description", 5);
            fail("Item.Item() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            item = new Item("name", "", 5);
            fail("Item.Item() should throw an IllegalArgumentException if the description argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            item = new Item("name", "description", 0);
            fail("Item.Item() should throw an IllegalArgumentException if the minPrice argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            item = new Item("name", "description", -1);
            fail("Item.Item() should throw an IllegalArgumentException if the minPrice argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testAddBidNullArgument() {
        try {
            item.addBid(null, 5);
            fail("Item.addBid() should throw a NullPointerException if the person argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddBidIllegalArgument() {
        try {
            item.addBid(person1, 0);
            fail("Item.addBid() should throw an IllegalArgumentException if the price argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            item.addBid(person1, -1);
            fail("Item.addBid() should throw an IllegalArgumentException if the price argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testAddBid() {
        item.addBid(person1, 4);
        assertEquals("Item.addBid() shouldn't create a new bid if its price is below the minPrice!", 0,
                item.getAllBids().size());
        assertNull("Item.addBid() should not set a highest bid, when its price is below the minPrice!",
                item.getHighestBid());

        item.addBid(person1, 5);
        assertEquals("Item.addBid() should create a new bid!", 1, item.getAllBids().size());
        bid = item.getHighestBid();
        assertTrue("Item.addBid() should set bid as highest bid, when bid's price is higher than minPrice!",
                bid.getBidder() == person1 && bid.getPrice() == 5);

        item.addBid(person2, 6);
        assertEquals("Item.addBid() should create a new bid!", 2, item.getAllBids().size());
        bid = item.getHighestBid();
        assertTrue("Item.addBid() should set bid as highest bid, when bid's price is higher than current highest bid!",
                bid.getBidder() == person2 && bid.getPrice() == 6);

        item.addBid(personNotHighestPrice, 1);
        assertEquals("Item.addBid() shouldn't create a new bid, if the price isn't higher than current highest bid!",
                2, item.getAllBids().size());
        bid = item.getHighestBid();
        assertTrue("Item.addBid() shouldn't change the highest bid, when bid's price isn't higher than current highest bid!",
                bid.getBidder() == person2 && bid.getPrice() == 6);

        item.addBid(personNotHighestPrice, 6);
        assertEquals("Item.addBid() shouldn't create a new bid, if the price isn't higher than current highest bid!",
                2, item.getAllBids().size());
        bid = item.getHighestBid();
        assertTrue("Item.addBid() shouldn't change the highest bid, when bid's price isn't higher than current highest bid!",
                bid.getBidder() == person2 && bid.getPrice() == 6);

        List<Bid> allBids = item.getAllBids();
        assertEquals("Item.getAllBids() should return a list containing all bids which were the highestBid!",
                2, allBids.size());
    }

    @Test
    public void testGetName() {
        assertEquals("Item.getName() should return the correct value!", "Blueprint", item.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Item.getDescription() should return the correct value!",
                "A blueprint for building a touch screen", item.getDescription());
    }

    @Test
    public void testToString() {
        assertEquals("Item.toString() should return the correct value!",
                "Blueprint: A blueprint for building a touch screen (minimum bidding price: 5 EUR)", item.toString());
    }
}
