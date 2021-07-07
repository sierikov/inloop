import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class AuctionTest {
    protected Auction auction;
    protected Item socks, book, clock;

    @Before
    public void setUp() {
        auction = new AuctionImpl();
        socks = new Item("Socks", "Ancient socks", 1);
        book = new Item("Book", "Ancient book", 5000);
        clock = new Item("Clock", "Ancient clock", 1000);
    }

    @Test
    public void testRegisterItem() {
        assertEquals("In the beginning, Auction.allItems should be empty!", 0, auction.getAllItems().size());
        auction.registerItem(new Item("Book", "Ancient book", 5000));
        assertEquals("Auction.registerItem() should actually add an item to allItems!", 1, auction.getAllItems().size());
        assertEquals("Auction.registerItem() shouldn't change the order of the items!", "Book", auction.getAllItems().get(0).getName());
        auction.registerItem(new Item("CD", "Ancient cd", 5));
        assertEquals("Auction.registerItem() should actually add an item to allItems!", 2, auction.getAllItems().size());
        assertEquals("Auction.registerItem() shouldn't change the order of the items!", "CD", auction.getAllItems().get(1).getName());
    }

    @Test
    public void testGenerateAllBidsStringNoBids() {
        for (Item item : List.of(socks, book, clock)) {
            auction.registerItem(item);
        }
        List<Item> items = auction.getAllItems();
        assertNotNull("Auction.getAllItems() must not return null", items);
        for (Item item : items) {
            String allBidsString = auction.generateAllBidsString(item);
            assertNotNull("Auction.generateAllBidsString() must not return null", allBidsString);
            assertEquals("Auction.generateAllBidsString() returns incorrect string when there are no bids",
                         "All bids:", allBidsString.trim());
        }
    }

    @Test
    public void testGenerateAllBidsString() {
        for (Item item : List.of(socks, book, clock)) {
            auction.registerItem(item);
        }
        auction.addBid(socks, "Max", 1);
        auction.addBid(book, "Moritz", 7000);
        auction.addBid(clock, "Max", 1000);
        auction.addBid(clock, "Moritz", 2000);

        // Strings (instead of Items) are used as keys, because equals()
        // and/or hashCode() in submitted Item class might be bogus
        Map<String, Item> expectedItemStrings = Map.of(
            "All bids:\n1 EUR by Max", socks,
            "All bids:\n7000 EUR by Moritz", book,
            "All bids:\n1000 EUR by Max\n2000 EUR by Moritz", clock
        );

        for (Entry<String, Item> entry : expectedItemStrings.entrySet()) {
            String allBidsString = auction.generateAllBidsString(entry.getValue());
            assertNotNull("Auction.generateAllBidsString() must not return null", allBidsString);
            assertEquals("Auction.generateAllBidsString() should return the correct string",
                         entry.getKey(), allBidsString.trim());
        }
    }

    @Test
    public void testCloseAuction() {
        auction.registerItem(clock);
        assertEquals("Auction.closeAuction() should call generateItemListString()", auction.generateItemListString(),
                auction.closeAuction());
        try {
            auction.closeAuction();
            fail("Auction.closeAuction() should throw an IllegalStateException if the auction is already closed!");
        } catch (IllegalStateException e) {
        }
        try {
            auction.addBid(clock, "bidder", 2);
            fail("Auction.addBid() should throw an IllegalStateException if the auction is already closed!");
        } catch (IllegalStateException e) {
        }
        try {
            auction.registerItem(new Item("name", "description", 2));
            fail("Auction.registerItem() should throw an IllegalStateException if the auction is already closed!");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testAddBidNullArgument() {
        auction.registerItem(clock);
        try {
            auction.addBid(null, "Max", 5);
            fail("Auction.addBid() should throw a NullPointerException if the itemName argument is null!");
        } catch (NullPointerException e) {
        }
        try {
            auction.addBid(clock, null, 5);
            fail("Auction.addBid() should throw auction NullPointerException if the nameOfBidder argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddBidIllegalArgument() {
        auction.registerItem(clock);

        try {
            auction.addBid(clock, "", 5);
            fail("Auction.addBid() should throw an IllegalArgumentException if the nameOfBidder argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            auction.addBid(clock, "Max", 0);
            fail("Auction.addBid() should throw an IllegalArgumentException if the price argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            auction.addBid(clock, "Max", -1);
            fail("Auction.addBid() should throw an IllegalArgumentException if the price argument is negative!");
        } catch (IllegalArgumentException e) {
        }

        Item unregisteredItem = new Item("New", "an Item that is not registered in the auction", 1);

        try {
            auction.addBid(unregisteredItem, "Max", 5);
            fail("Auction.addBid() should throw a NoSuchElementException if no item in the auction has the given name!");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void testRegisterItemIllegalArgument() {
        auction.registerItem(new Item("duplicate", "description", 1));

        try {
            auction.registerItem(new Item("duplicate", "description", 1));
            fail("Auction.registerItem() should throw an IllegalArgumentException if the item has the same name as an Auction's item!");
        } catch (IllegalArgumentException e) {
        }

    }

    @Test
    public void testRegisterItemNullArgument() {
        try {
            auction.registerItem(null);
            fail("Auction.registerItem() should throw a NullPointerException if the item is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGenerateAllBidsStringNullArgument() {
        try {
            auction.generateAllBidsString(null);
            fail("Auction.generateAllBidsString() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetAllItems() {
        for (Item item : List.of(book, clock)) {
            auction.registerItem(item);
        }
        List<Item> expected = List.of(book, clock);
        List<Item> actual = auction.getAllItems();
        assertEquals("Auction.getAllItems() should return a List of all registered Items!", expected, actual);
    }

    private static class AuctionImpl extends Auction {
        @Override
        public String generateItemString(Item item) {
            return "";
        }
    }
}
