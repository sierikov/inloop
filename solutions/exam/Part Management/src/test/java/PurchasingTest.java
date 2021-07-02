import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class PurchasingTest {
    private Purchasing purch;
    private Part part;
    private ReceivingStock rStock;

    @Before
    public void setUp() {
        rStock = new ReceivingStock(10, 100);
        purch = new Purchasing(rStock);
        part = new Components("id", "TestComponent");
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Purchasing(null);
            fail("Purchasing.Purchasing() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testBuyIllegalArgument() {
        try {
            purch.buy(null, 10);
            fail("Purchasing.buy() should throw a NullPointerException if the part argument is null!");
        } catch (NullPointerException e) {
        }
        try {
            purch.buy(part, 0);
            fail("Purchasing.buy() should throw an IllegalArgumentException if the count argument less than one!");
        } catch (IllegalArgumentException e) {
        }
        try {
            purch.buy(part, -1);
            fail("Purchasing.buy() should throw an IllegalArgumentException if the count argument is less than one!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testBuy() {
        purch.buy(part, 25);
        assertEquals(
                "Purchasing.buy() should add the specified number of parts to the stock even if the stock did not contain the part!",
                25, purch.getStock().getCount(part));
        part = new SingleComponent("S5", "a single component");
        rStock.insert(part, 10);
        purch.buy(part, 13);
        assertEquals("Purchasing.buy() should add the specified number of parts to the stock!", 23, purch.getStock()
                .getCount(part));
    }

    @Test
    public void testGetStock() {
        assertEquals("Purchasing.getStock() should return the correct object!", rStock, purch.getStock());
    }

    @Test
    public void onPartCountChangedTest() {
        rStock.addObserver(purch);
        rStock.insert(part, 25);
        rStock.remove(part, 16);
        assertEquals("Purchasing.onPartCountChanged() should restock if the amount is lower than minStockitems!", 100,
                rStock.getCount(part));
    }
}
