import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class AuctionTest {
    protected Auction a;

    @Before
    public void setUp() {
        a = new AuctionImpl();
    }

    @Test
    public void testRegisterItem() {
        assertEquals("In the beginning, Auction.allItems should be empty!", 0, a.getAllItems().size());
        a.registerItem(new Item("Book", "Ancient book", 5000));
        assertEquals("Auction.registerItem() should actually add an item to allItems!", 1, a.getAllItems().size());
        assertEquals("Auction.registerItem() shouldn't change the order of the items!", "Book", a.getAllItems().get(0).getName());
        a.registerItem(new Item("CD", "Ancient cd", 5));
        assertEquals("Auction.registerItem() should actually add an item to allItems!", 2, a.getAllItems().size());
        assertEquals("Auction.registerItem() shouldn't change the order of the items!", "CD", a.getAllItems().get(1).getName());
    }

    @Test
    public void testGenerateAllBidsString() {
        String[] result = new String[6];
        result[0] = "All bids:";
        result[1] = "All bids:";
        result[2] = "All bids:";
        result[3] = "All bids:\n1 EUR by Max";
        result[4] = "All bids:\n7000 EUR by Moritz";
        result[5] = "All bids:\n1000 EUR by Max\n2000 EUR by Moritz";

        a.registerItem(new Item("Socks", "Ancient socks", 1));
        a.registerItem(new Item("Book", "Ancient book", 5000));
        a.registerItem(new Item("Clock", "Ancient clock", 1000));

        for (int i = 0; i < 2; i++) {
            assertEquals("Auction.generateAllBidsString() should return the correct String!", result[i],
                    a.generateAllBidsString(a.getAllItems().get(i)));
        }

        a.addBid("Socks", "Max", 1);
        a.addBid("Book", "Moritz", 7000);
        a.addBid("Clock", "Max", 1000);
        a.addBid("Clock", "Moritz", 2000);

        for (int i = 0; i < 2; i++) {
            assertEquals("Auction.generateAllBidsString() should return the correct String!", result[3 + i],
                    a.generateAllBidsString(a.getAllItems().get(i)));
        }
    }

    @Test
    public void testCloseAuction() {
        assertEquals("Auction.closeAuction() should call generateItemListString()", a.generateItemListString(),
                a.closeAuction());

        try {
            a.closeAuction();
            fail("Auction.closeAuction() should throw an IllegalStateException if the auction is already closed!");
        } catch (IllegalStateException e) {
        }

        try {
            a.addBid("item", "bidder", 2);
            fail("Auction.addBid() should throw an IllegalStateException if the auction is already closed!");
        } catch (IllegalStateException e) {
        }

        try {
            a.registerItem(new Item("name", "description", 2));
            fail("Auction.registerItem() should throw an IllegalStateException if the auction is already closed!");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testAddBidNullArgument() {
        a.registerItem(new Item("Clock", "Ancient clock", 1000));
        try {
            a.addBid(null, "Max", 5);
            fail("Auction.addBid() should throw a NullPointerException if the itemName argument is null!");
        } catch (NullPointerException e) {
        }
        try {
            a.addBid("Clock", null, 5);
            fail("Auction.addBid() should throw a NullPointerException if the nameOfBidder argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddBidIllegalArgument() {
        a.registerItem(new Item("Clock", "Ancient clock", 1000));
        try {
            a.addBid("", "Max", 5);
            fail("Auction.addBid() should throw an IllegalArgumentException if the itemName argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            a.addBid("Clock", "", 5);
            fail("Auction.addBid() should throw an IllegalArgumentException if the nameOfBidder argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            a.addBid("Clock", "Max", 0);
            fail("Auction.addBid() should throw an IllegalArgumentException if the price argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            a.addBid("Clock", "Max", -1);
            fail("Auction.addBid() should throw an IllegalArgumentException if the price argument is negative!");
        } catch (IllegalArgumentException e) {
        }

        try {
            a.addBid("New", "Max", 5);
            fail("Auction.addBid() should throw a NoSuchElementException if no item in the auction has the given name!");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void testRegisterItemIllegalArgument() {
        a.registerItem(new Item("duplicate", "description", 1));

        try {
            a.registerItem(new Item("duplicate", "description", 1));
            fail("Auction.registerItem() should throw an IllegalArgumentException if the item has the same name as an Auction's item!");
        } catch (IllegalArgumentException e) {
        }

    }

    @Test
    public void testRegisterItemNullArgument() {
        try {
            a.registerItem(null);
            fail("Auction.registerItem() should throw a NullPointerException if the item is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGenerateAllBidsStringNullArgument() {
        try {
            a.generateAllBidsString(null);
            fail("Auction.generateAllBidsString() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetAllItems() {
        Item i1 = new Item("Book", "Ancient book", 5000);
        Item i2 = new Item("CD", "Ancient cd", 5);
        a.registerItem(i1);
        a.registerItem(i2);
        assertEquals("Auction.getAllItems() should return a List of all registered Items!", Arrays.asList(i1, i2), a.getAllItems());
    }

    private static class AuctionImpl extends Auction {
        @Override
        public String generateItemString(Item item) {
            return "";
        }
    }
}
