import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class PercentageDiscountPricingTest {
    private Sale myTestSale;
    private ISalePricing myTestPricing;

    @Before
    public void setUp() {
        myTestPricing = new PercentageDiscountPricing(10.0);
        myTestSale = new Sale(20000, myTestPricing);
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new PercentageDiscountPricing(-Double.MIN_VALUE);
            fail("PercentageDiscountPricing.PercentageDiscountPricing() should throw an IllegalArgumentException if the argument is negative!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new PercentageDiscountPricing(100.000000001);
            fail("PercentageDiscountPricing.PercentageDiscountPricing() should throw an IllegalArgumentException if the argument is greater than 100!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetTotalNullArgument() {
        try {
            myTestPricing.getTotal(null);
            fail("PercentageDiscountPricing.getTotal() should throw a NullPointerEception if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetTotal() {
        assertEquals("PercentageDiscountPricing.getTotal() should return the correct total price!", 18000,
                myTestPricing.getTotal(myTestSale));

        myTestPricing = new PercentageDiscountPricing(3.33);
        assertEquals("PercentageDiscountPricing.getTotal() should return the correct total price!", 19334,
                myTestPricing.getTotal(myTestSale));
    }
}
