import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class AllPayAuctionTest extends AuctionTest {
    @Override
    @Before
    public void setUp() {
        a = new AllPayAuction();
    }

    @Test
    public void testSuperclass() {
        assertEquals("AllPayAuction should be a subclass of Auction!", Auction.class,
                AllPayAuction.class.getSuperclass());
    }

    @Test
    public void testGenerateItemStringNullArgument() {
        try {
            a.generateItemString(null);
            fail("AllPayAuction.generateItemString() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGenerateItemListString() {
        String[] result = new String[2];
        result[0] = "Socks: Ancient socks (minimum bidding price: 1 EUR)\nNo bids placed\n"
                + "Book: Ancient book (minimum bidding price: 5000 EUR)\nNo bids placed\n"
                + "Clock: Ancient clock (minimum bidding price: 1000 EUR)\nNo bids placed\n";
        result[1] = "Socks: Ancient socks (minimum bidding price: 1 EUR)\nHighest bid: 1 EUR by Max\n"
                + "All bids:\n1 EUR by Max\n"
                + "Book: Ancient book (minimum bidding price: 5000 EUR)\nHighest bid: 7000 EUR by Moritz\n"
                + "All bids:\n7000 EUR by Moritz\n"
                + "Clock: Ancient clock (minimum bidding price: 1000 EUR)\nHighest bid: 2000 EUR by Moritz\n"
                + "All bids:\n1000 EUR by Max\n2000 EUR by Moritz\n";

        a.registerItem(new Item("Socks", "Ancient socks", 1));
        a.registerItem(new Item("Book", "Ancient book", 5000));
        a.registerItem(new Item("Clock", "Ancient clock", 1000));

        assertEquals("Auction.generateItemListString() should return the correct String!", result[0],
                a.generateItemListString());

        a.addBid("Socks", "Max", 1);
        a.addBid("Book", "Moritz", 7000);
        a.addBid("Clock", "Max", 1000);
        a.addBid("Clock", "Moritz", 2000);

        assertEquals("Auction.generateItemListString() should return the correct String!", result[1],
                a.generateItemListString());
    }

    @Test
    public void testGenerateItemString() {
        String[] result = new String[6];
        result[0] = "Socks: Ancient socks (minimum bidding price: 1 EUR)\nNo bids placed";
        result[1] = "Book: Ancient book (minimum bidding price: 5000 EUR)\nNo bids placed";
        result[2] = "Clock: Ancient clock (minimum bidding price: 1000 EUR)\nNo bids placed";
        result[3] = "Socks: Ancient socks (minimum bidding price: 1 EUR)\nHighest bid: 1 EUR by Max\n"
                + "All bids:\n1 EUR by Max";
        result[4] = "Book: Ancient book (minimum bidding price: 5000 EUR)\nHighest bid: 7000 EUR by Moritz\n"
                + "All bids:\n7000 EUR by Moritz";
        result[5] = "Clock: Ancient clock (minimum bidding price: 1000 EUR)\nHighest bid: 2000 EUR by Moritz\n"
                + "All bids:\n1000 EUR by Max\n2000 EUR by Moritz";

        a.registerItem(new Item("Socks","Ancient socks", 1));
        a.registerItem(new Item("Book", "Ancient book", 5000));
        a.registerItem(new Item("Clock", "Ancient clock", 1000));

        for (int i = 0; i < 2; i++) {
            assertEquals("AllPayAuction.generateItemString() should return the correct String!", result[i],
                    a.generateItemString(a.getAllItems().get(i)));
        }

        a.addBid("Socks", "Max", 1);
        a.addBid("Book", "Moritz", 7000);
        a.addBid("Clock", "Max", 1000);
        a.addBid("Clock", "Moritz", 2000);

        for (int i = 0; i < 2; i++) {
            assertEquals("AllPayAuction.generateItemString() should return the correct String!", result[3 + i],
                    a.generateItemString(a.getAllItems().get(i)));
        }
    }
}
