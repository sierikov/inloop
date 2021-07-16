import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PeasantTest {
    private Inhabitant peasant;

    @Before
    public void setUp() {
        peasant = new Peasant();
    }

    @Test
    public void testTaxableIncome() {
        peasant.setIncome(0);
        assertEquals("Peasant.taxableIncome() should return the Peasant's income correctly!", 0, peasant.taxableIncome());

        peasant.setIncome(10);
        assertEquals("Peasant.taxableIncome() should return the Peasant's income correctly!", 10, peasant.taxableIncome());
    }

    @Test
    public void testTax() {
        peasant.setIncome(0);
        assertEquals("Peasant.tax() should return the Peasant's tax value correctly!", 1, peasant.tax());

        peasant.setIncome(1);
        assertEquals("Peasant.tax() should return the Peasant's tax value correctly!", 1, peasant.tax());

        peasant.setIncome(10);
        assertEquals("Peasant.tax() should return the Peasant's tax value correctly!", 1, peasant.tax());

        peasant.setIncome(20);
        assertEquals("Peasant.tax() should return the Peasant's tax value correctly!", 2, peasant.tax());

        peasant.setIncome(25);
        assertEquals("Peasant.tax() should return the Peasant's tax value correctly!", 2, peasant.tax());
    }
}
