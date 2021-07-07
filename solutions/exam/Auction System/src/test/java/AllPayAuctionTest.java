import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

public class AllPayAuctionTest extends AuctionTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
        auction = new AllPayAuction();
    }

    @Test
    public void testSuperclass() {
        assertEquals("AllPayAuction should be a subclass of Auction!", Auction.class,
                AllPayAuction.class.getSuperclass());
    }

    @Test
    public void testGenerateItemStringNullArgument() {
        try {
            auction.generateItemString(null);
            fail("AllPayAuction.generateItemString() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGenerateItemListString() {
        for (Item item : List.of(socks, book, clock)) {
            auction.registerItem(item);
        }

        String expectedItemListStringBeforeBidding = "Socks: Ancient socks (minimum bidding price: 1 EUR)\nNo bids placed\n"
                + "Book: Ancient book (minimum bidding price: 5000 EUR)\nNo bids placed\n"
                + "Clock: Ancient clock (minimum bidding price: 1000 EUR)\nNo bids placed";

        assertEquals("Auction.generateItemListString() should return the correct String!",
                expectedItemListStringBeforeBidding, auction.generateItemListString().trim());

        auction.addBid(socks, "Max", 1);
        auction.addBid(book, "Moritz", 7000);
        auction.addBid(clock, "Max", 1000);
        auction.addBid(clock, "Moritz", 2000);

        String expectedItemListStringAfterBidding = "Socks: Ancient socks (minimum bidding price: 1 EUR)\nHighest bid: 1 EUR by Max\n"
                + "All bids:\n1 EUR by Max\n"
                + "Book: Ancient book (minimum bidding price: 5000 EUR)\nHighest bid: 7000 EUR by Moritz\n"
                + "All bids:\n7000 EUR by Moritz\n"
                + "Clock: Ancient clock (minimum bidding price: 1000 EUR)\nHighest bid: 2000 EUR by Moritz\n"
                + "All bids:\n1000 EUR by Max\n2000 EUR by Moritz";

        assertEquals("Auction.generateItemListString() should return the correct String!",
                expectedItemListStringAfterBidding, auction.generateItemListString().trim());
    }

    @Test
    public void testGenerateItemString() {
        for (Item item : List.of(socks, book, clock)) {
            auction.registerItem(item);
        }

        Map<String, Item> expectedItemStringsBeforeBidding = Map.of(
                "Socks: Ancient socks (minimum bidding price: 1 EUR)\nNo bids placed", socks,
                "Book: Ancient book (minimum bidding price: 5000 EUR)\nNo bids placed", book,
                "Clock: Ancient clock (minimum bidding price: 1000 EUR)\nNo bids placed", clock
        );

        for (Entry<String, Item> entry : expectedItemStringsBeforeBidding.entrySet()) {
            String expectedString = entry.getKey();
            Item item = entry.getValue();
            assertEquals("AllPayAuction.generateItemString() should return the correct String!",
                    expectedString, auction.generateItemString(item).trim());
        }

        auction.addBid(socks, "Max", 1);
        auction.addBid(book, "Moritz", 7000);
        auction.addBid(clock, "Max", 1000);
        auction.addBid(clock, "Moritz", 2000);

        Map<String, Item> expectedItemStringsAfterBidding = Map.of(
                "Socks: Ancient socks (minimum bidding price: 1 EUR)\nHighest bid: 1 EUR by Max\n"
                        + "All bids:\n1 EUR by Max", socks,
                "Book: Ancient book (minimum bidding price: 5000 EUR)\nHighest bid: 7000 EUR by Moritz\n"
                        + "All bids:\n7000 EUR by Moritz", book,
                "Clock: Ancient clock (minimum bidding price: 1000 EUR)\nHighest bid: 2000 EUR by Moritz\n"
                        + "All bids:\n1000 EUR by Max\n2000 EUR by Moritz", clock
        );

        for (Entry<String, Item> entry : expectedItemStringsAfterBidding.entrySet()) {
            String expectedString = entry.getKey();
            Item item = entry.getValue();
            assertEquals("AllPayAuction.generateItemString() should return the correct String!",
                    expectedString, auction.generateItemString(item).trim());
        }
    }
}
