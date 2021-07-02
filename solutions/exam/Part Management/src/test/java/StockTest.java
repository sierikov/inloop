import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StockTest {
    protected Stock stock;
    protected Part part;

    @Before
    public void setUp() {
        stock = new Stock() {
            // instantiation of an anonymous inner subclass of Stock
        };
        part = new SingleComponent("0", "singComp");

        stock.insert(part, 15);
    }

    @Test
    public void testGetCountNullArgument() {
        try {
            stock.getCount(null);
            fail("Stock.get() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetCount() {
        assertEquals("Stock.getCount() should return -1 if the stock does not contain the part!", -1,
                stock.getCount(new Resource("1", "resComp")));
        assertEquals("Stock.getCount() should return the correct number of parts within the stock!", 15, stock.getCount(part));
    }

    @Test
    public void testInsertIllegalArgument() {
        try {
            stock.insert(null, 15);
            fail("ReceivingStock.insert() should throw a NullPointerException if the part argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            stock.insert(part, 0);
            fail("ReceivingStock.insert() should throw an IllegalArgumentException if the count argument is less than one!");
        } catch (IllegalArgumentException e) {
        }

        try {
            stock.insert(part, -1);
            fail("ReceivingStock.insert() should throw an IllegalArgumentException if the count argument is less than one!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testInsert() {
        SingleComponent sc = new SingleComponent("3", "name");
        assertTrue("Stock.insert() should return true if the part was successfully inserted!", stock.insert(sc, 15));
        assertEquals("Stock.insert() should add new parts to the stock if it did not contain these parts previously!",
                15, stock.getCount(sc));
        stock.insert(sc, 15);
        assertEquals("Stock.insert() should insert the correct number of parts into the stock!", 30, stock.getCount(sc));
    }

    @Test
    public void testRemoveNullArgument() {
        try {
            stock.remove(null, 10);
            fail("Stock.remove() should throw a NullPointerException if the part argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testRemoveIllegalArgument() {
        try {
            stock.remove(part, 0);
            fail("Stock.remove() should throw an IllegalArgumentException if the count argument is less than 1!");
        } catch (IllegalArgumentException e) {
        }

        try {
            stock.remove(part, -1);
            fail("Stock.remove() should throw an IllegalArgumentException if the count argument is less than 1!");
        } catch (IllegalArgumentException e) {
        }

        assertEquals("Stock.remove() should not change part count if the count argument is invalid!",
                15, stock.getCount(part));
    }

    @Test
    public void testRemove() {
        assertFalse("Stock.remove() should return false if the part is not in the stock!",
                stock.remove(new Resource("1", "resComp"), 1));
        assertFalse(
                "Stock.remove() should return false if the count argument is greater than the number of parts within the stock!",
                stock.remove(part, 20));
        assertEquals("Stock.remove() should not remove any parts from the stock if the count argument is invalid!",
                15, stock.getCount(part));
        assertTrue("Stock.remove() should return true if parts were removed successfully!", stock.remove(part, 4));
        assertEquals("Stock.remove() should actually remove parts from the stock!", 11, stock.getCount(part));
    }

    @Test
    public void testAddObserverNullArgument() {
        try {
            stock.addObserver(null);
            fail("Stock.addObserver() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }  
}
