import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SerfTest {
    @Test
    public void testTaxableIncome() {
        Peasant serf = new Serf();

        int income;
        for (int i = 0; i <= 12; i++) {
            income = serf.taxableIncome();
            assertEquals("Serf.taxableIncome() should respect the royal instruction 5"
                    + (income < 0 ? " and not return a value below 0" : "") + "!", 0, income);
        }

        serf.setIncome(13);
        assertEquals("Serf.taxableIncome() should respect the royal instruction 5!", 1, serf.taxableIncome());

        serf.setIncome(20);
        assertEquals("Serf.taxableIncome() should respect the royal instruction 5!", 8, serf.taxableIncome());
    }
}
