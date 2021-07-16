import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PeasantTest {
    private Inhabitant p;

    @Before
    public void setUp() {
        p = new Peasant();
    }

    @Test
    public void testTaxableIncome() {
        p.setIncome(0);
        assertEquals("Peasant.taxableIncome() should return the Peasant's income correctly!", 0, p.taxableIncome());

        p.setIncome(10);
        assertEquals("Peasant.taxableIncome() should return the Peasant's income correctly!", 10, p.taxableIncome());

        p.setIncome(-1);
        assertEquals("Peasant.taxableIncome() should return the Peasant's income correctly!", -1, p.taxableIncome());
    }

    @Test
    public void testTax() {
        p.setIncome(0);
        assertEquals("Peasant.tax() should return the Peasant's tax value correctly!", 1, p.tax());

        p.setIncome(1);
        assertEquals("Peasant.tax() should return the Peasant's tax value correctly!", 1, p.tax());

        p.setIncome(10);
        assertEquals("Peasant.tax() should return the Peasant's tax value correctly!", 1, p.tax());

        p.setIncome(20);
        assertEquals("Peasant.tax() should return the Peasant's tax value correctly!", 2, p.tax());

        p.setIncome(25);
        assertEquals("Peasant.tax() should return the Peasant's tax value correctly!", 2, p.tax());
    }
}
