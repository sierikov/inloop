import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class SaleTest {
    private Sale sale1, sale2;
    private PercentageDiscountPricing pricing1 = new PercentageDiscountPricing(10.0);
    private AbsoluteDiscountPricing pricing2 = new AbsoluteDiscountPricing(500, 1000);
    private static long preDiscountTotal1 = 10000;
    private static long preDiscountTotal2 = 2000;

    @Before
    public void setUp() {
        sale1 = new Sale(preDiscountTotal1, pricing1);
        sale2 = new Sale(preDiscountTotal2, pricing2);
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Sale(-1, pricing1);
            fail("Sale.Sale() should throw an IllegalArgumentException if the preDiscountTotal argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Sale(preDiscountTotal1, null);
            fail("Sale.Sale() should throw a NullPointerException if the pricing argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetPreDiscountTotal() {
        assertEquals("Sale.getPreDiscountTotal() should return the correct value!", preDiscountTotal1,
                sale1.getPreDiscountTotal());
        assertEquals("Sale.getPreDiscountTotal() should return the correct value!", preDiscountTotal2,
                sale2.getPreDiscountTotal());
    }

    @Test
    public void testSetPricingNullArgument() {
        try {
            sale1.setPricing(null);
            fail("Sale.setPricing() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testSetPricing() {
        sale2.setPricing(pricing1);
        assertEquals("Sale.setPricing() should set the pricing correctly!", 1800, sale2.getTotal());
    }

    @Test
    public void testGetTotal() {
        assertEquals("Sale.getTotal() should return the correct total cost for a PercentageDiscountPricing!", 9000,
                sale1.getTotal());
        assertEquals("Sale.getTotal() should return the correct total cost for an AbsoluteDiscountPricing!", 1500,
                sale2.getTotal());
    }

    @Test
    public void testCreatePricingStatic() throws NoSuchMethodException {
        assertTrue(
                "Sale.createPricing() should be static!",
                Modifier.isStatic(Sale.class.getMethod("createPricing", DiscountType.class, double.class, long.class,
                        long.class).getModifiers()));
    }

    @Test
    public void testCreatePricingNullArgument() {
        try {
            Sale.createPricing(null, 0, 0, 0);
            fail("Sale.createPricing() should throw a NullPointerException if the discountType argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testCreatePricing() {
        ISalePricing e1 = Sale.createPricing(DiscountType.PERCENTAGEDISCOUNT, 10.0, 0, 0);
        assertSame("Sale.createPricing() should return the kind of object specified by the discountType argument!",
                PercentageDiscountPricing.class, e1.getClass());
        e1 = Sale.createPricing(DiscountType.ABSOLUTEDISCOUNT, 0.0, 999, 1000);
        assertSame("Sale.createPricing() should return the kind of object specified by the discountType argument!",
                AbsoluteDiscountPricing.class, e1.getClass());
    }
}
