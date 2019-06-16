import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ReceivingStockTest extends StockTest {
    private Purchasing purch;

    @Override
    @Before
    public void setUp() {
        stock = new ReceivingStock(10, 100);
        purch = new Purchasing((ReceivingStock) stock);
        part = Factory.createPart(PartType.SINGLE_COMPONENT, "0", "A Single Component");

        stock.insert(part, 15);
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new ReceivingStock(-1, 1);
            fail("ReceivingStock.ReceivingStock() should throw an IllegalArgumentException if the minStockItems argument is less than 1!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new ReceivingStock(0, -1);
            fail("ReceivingStock.ReceivingStock() should throw an IllegalArgumentException if the maxStockItems argument is less than the minStockItems argument!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new ReceivingStock(5, 4);
            fail("ReceivingStock.ReceivingStock() should throw an IllegalArgumentException if the maxStockItems argument is less than or equal to the minStockItems argument!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new ReceivingStock(4, 4);
            fail("ReceivingStock.ReceivingStock() should throw an IllegalArgumentException if the maxStockItems argument is less than or equal to the minStockItems argument!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testObserver() {
        stock.addObserver(purch);
        stock.remove(part, 6);
        assertEquals(
                "It seems that Stock.addObserver() or Stock.notifyPartCountChanged() are not implemented correctly! The ReceivingStock is not getting refilled correctly.",
                100, stock.getCount(part));
    }

    @Test
    public void testGetMinStockItems() {
        assertEquals("ReceivingStock.getMinStockItems() should return the correct value!", 10,
                ((ReceivingStock) stock).getMinStockItems());
    }

    @Test
    public void testGetMaxStockItems() {
        assertEquals("ReceivingStock.getMaxStockItems() should return the correct value!", 100,
                ((ReceivingStock) stock).getMaxStockItems());
    }

    @Test
    public void testReceivingStockInsert() {
        assertFalse("ReceivingStock.insert() should return false if the new amount would exceed maxStockItems!", ((ReceivingStock) stock).insert(part, 10000));
    }

    @Test
    public void testReceivingStockRemove() {
        assertFalse("ReceivingStock.remove() should return false if the new amount would fall below zero!", ((ReceivingStock) stock).remove(part, 16));
    }
}
