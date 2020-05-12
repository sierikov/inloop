import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class InhabitantTest {
    private Inhabitant i;

    @Before
    public void setUp() {
        i = new Inhabitant();
    }

    @Test
    public void testTaxableIncome() {
        i.setIncome(0);
        assertEquals("Inhabitant.taxableIncome() should return the Inhabitant's income correctly!", 0,
                i.taxableIncome());

        i.setIncome(10);
        assertEquals("Inhabitant.taxableIncome() should return the Inhabitant's income correctly!", 10,
                i.taxableIncome());

        i.setIncome(-1);
        assertEquals("Inhabitant.taxableIncome() should return the Inhabitant's income correctly!", -1,
                i.taxableIncome());
    }

    @Test
    public void testTax() {
        i.setIncome(0);
        assertEquals("Inhabitant.tax() should return the Inhabitant's tax value correctly!", 1, i.tax());

        i.setIncome(1);
        assertEquals("Inhabitant.tax() should return the Inhabitant's tax value correctly!", 1, i.tax());

        i.setIncome(10);
        assertEquals("Inhabitant.tax() should return the Inhabitant's tax value correctly!", 1, i.tax());

        i.setIncome(20);
        assertEquals("Inhabitant.tax() should return the Inhabitant's tax value correctly!", 2, i.tax());

        i.setIncome(25);
        assertEquals("Inhabitant.tax() should return the Inhabitant's tax value correctly!", 2, i.tax());
    }
}
