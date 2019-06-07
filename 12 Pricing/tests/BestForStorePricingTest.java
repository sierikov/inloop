import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class BestForStorePricingTest {
    private Sale testSale;
    private ISalePricing p1, p2, p3, p4, p5;

    @Before
    public void setUp() {
        p1 = new PercentageDiscountPricing(10.0); // 9000
        p2 = new PercentageDiscountPricing(5.0); // 9500
        p3 = new AbsoluteDiscountPricing(500, 5000); // 9500
        p4 = new AbsoluteDiscountPricing(3000, 9000); // 9000
        p5 = new AbsoluteDiscountPricing(1900, 8000); // 8100

        testSale = new Sale(10000, p1);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new BestForStorePricing(null);
            fail("BestForStorePricing.BestForStorePricing() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddNullArgument() {
        try {
            new BestForStorePricing(p1).add(null);
            fail("BestForStorePricing.add() should throw a NullPointerException if the argument is null!");
        } catch(NullPointerException e) {
        }
    }

    @Test
    public void testAdd() {
        List<ISalePricing> solution = new LinkedList<ISalePricing>();
        solution.add(p1);
        ComplexPricing cPricing = new BestForStorePricing(p1);
        assertEquals("BestForStorePricing.BestForStorePricing() should add the argument to the pricings!", solution,
                cPricing.getPricings());
        cPricing.add(p2);
        solution.add(p2);
        assertEquals("BestForStorePricing.add() should add the argument to the pricings!", solution,
                cPricing.getPricings());
        cPricing.add(p3);
        solution.add(p3);
        assertEquals("BestForStorePricing.add() should add the argument to the pricings!", solution,
                cPricing.getPricings());
    }

    @Test
    public void testGetTotalNullArgument() {
        try {
            BestForStorePricing p = new BestForStorePricing(p1);
            p.getTotal(null);
            fail("BestForStorePricing.getTotal() should throw a NullPointerEception if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetTotal() {
        BestForStorePricing p = new BestForStorePricing(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        testSale.setPricing(p);
        assertEquals("BestForStorePricing.getTotal() should return the correct total price!", 9500,
                testSale.getTotal());
    }
}