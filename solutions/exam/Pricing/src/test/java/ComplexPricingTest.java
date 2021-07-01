import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.junit.Test;

public class ComplexPricingTest {
    @Test
    public void testAbstract() {
        assertTrue("The class ComplexPricing should be abstract!",
                Modifier.isAbstract(ComplexPricing.class.getModifiers()));
    }

    @Test
    public void testOnlyOneConstructor() {
        Constructor<?>[] constructors = ComplexPricing.class.getConstructors();
        assertEquals("ComplexPricing should have only one public constructor!", 1, constructors.length);
        Class<?>[] params = constructors[0].getParameterTypes();
        assertEquals("ComplexPricing's constructor should have exactly one parameter!", 1, params.length);
        assertEquals("ComprexPricing's parameter should be of type ISalePricing!", ISalePricing.class, params[0]);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new ComplexPricingImpl(null);
            fail("The ComplexPricing constructor should throw a NullPointerException if its argument is null!");
        } catch (NullPointerException expected) {
        }
    }

    @Test
    public void testAddNullArgument() {
        try {
            new ComplexPricingImpl(new SalePricingMock()).add(null);
            fail("ComplexPricing.add() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetPricings() {
        ISalePricing p1 = new PercentageDiscountPricing(10.0); // 9000
        ISalePricing p2 = new PercentageDiscountPricing(5.0); // 9500
        ISalePricing p3 = new AbsoluteDiscountPricing(500, 5000); // 9500
        ISalePricing p4 = new AbsoluteDiscountPricing(3000, 9000); // 9000
        ISalePricing p5 = new AbsoluteDiscountPricing(1900, 8000); // 8100

        ComplexPricing complexPricing = new ComplexPricingImpl(p1);
        complexPricing.add(p2);
        complexPricing.add(p3);
        complexPricing.add(p4);
        complexPricing.add(p5);

        assertEquals("ComplexPricing.getTotal() should return the correct total price!", complexPricing.getPricings(),
                Arrays.asList(p1, p2, p3, p4, p5));
    }

    private static class ComplexPricingImpl extends ComplexPricing {
        public ComplexPricingImpl(ISalePricing pricing) {
            super(pricing);
        }

        @Override
        public long getTotal(Sale sale) {
            return 0;
        }
    }

    private static class SalePricingMock implements ISalePricing {
        @Override
        public long getTotal(Sale sale) {
            return 0;
        }
    }
}
