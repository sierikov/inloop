import static java.lang.reflect.Modifier.isProtected;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class InhabitantTest {
    private Inhabitant inhabitant;

    @Before
    public void setUp() {
        inhabitant = new Inhabitant();
    }

    @Test
    public void testIncomeAttribute() {
        for (Field field : Inhabitant.class.getDeclaredFields()) {
            if (field.getName().equals("income") && field.getType().equals(int.class)
                    && isProtected(field.getModifiers())) {
                return;
            }
        }
        fail("Inhabitant should have a protected attribute 'income' of type int.");
    }

    @Test
    public void testCheckForNegativeIncome() {
        try {
            inhabitant.setIncome(-1);
            fail("Inhabitant.setIncome() should throw an IllegalArgumentException if income is < 0!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testTaxableIncome() {
        inhabitant.setIncome(0);
        assertEquals("Inhabitant.taxableIncome() should return the Inhabitant's income correctly!",
                0, inhabitant.taxableIncome());

        inhabitant.setIncome(10);
        assertEquals("Inhabitant.taxableIncome() should return the Inhabitant's income correctly!",
                10, inhabitant.taxableIncome());
    }

    @Test
    public void testTax() {
        inhabitant.setIncome(0);
        assertEquals("Inhabitant.tax() should return the Inhabitant's tax value correctly!", 1,
                inhabitant.tax());

        inhabitant.setIncome(1);
        assertEquals("Inhabitant.tax() should return the Inhabitant's tax value correctly!", 1,
                inhabitant.tax());

        inhabitant.setIncome(10);
        assertEquals("Inhabitant.tax() should return the Inhabitant's tax value correctly!", 1,
                inhabitant.tax());

        inhabitant.setIncome(20);
        assertEquals("Inhabitant.tax() should return the Inhabitant's tax value correctly!", 2,
                inhabitant.tax());

        inhabitant.setIncome(25);
        assertEquals("Inhabitant.tax() should return the Inhabitant's tax value correctly!", 2,
                inhabitant.tax());
    }
}
