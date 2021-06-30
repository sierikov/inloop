import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class AbsoluteDiscountPricingTest {
    private Sale myTestSale;
    private ISalePricing myTestPricing;

    @Before
    public void setUp() {
        myTestPricing = new AbsoluteDiscountPricing(100, 1000);
        myTestSale = new Sale(20000, myTestPricing);
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new AbsoluteDiscountPricing(-1, 0);
            fail("AbsoluteDiscountPricing.AbsoluteDiscountPricing() should throw an IllegalArgumentException if the discount argument is negative!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new AbsoluteDiscountPricing(0, -1);
            fail("AbsoluteDiscountPricing.AbsoluteDiscountPricing() should throw an IllegalArgumentException if the threshold argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetTotalNullArgument() {
        try {
            myTestPricing.getTotal(null);
            fail("AbsoluteDiscountPricing.getTotal() should throw a NullPointerEception if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetTotal() {
        assertEquals("AbsoluteDiscountPricing.getTotal() should return the correct total price!", 19900,
                myTestPricing.getTotal(myTestSale));

        myTestPricing = new AbsoluteDiscountPricing(2000, 10000);
        assertEquals("AbsoluteDiscountPricing.getTotal() should return the correct total price!", 18000,
                myTestPricing.getTotal(myTestSale));
    }

    @Test
    public void testGetTotalLimitBefore() {
        myTestPricing = new AbsoluteDiscountPricing(2000, 25000);
        assertEquals("AbsoluteDiscountPricing.getTotal() should take care of a given threshold!", 20000,
                myTestPricing.getTotal(myTestSale));
    }

    @Test
    public void testGetTotalLimitAfter() {
        myTestPricing = new AbsoluteDiscountPricing(2000, 19000);
        assertEquals("AbsoluteDiscountPricing.getTotal() should take care of a given threshold!", 19000,
                myTestPricing.getTotal(myTestSale));
    }
}
