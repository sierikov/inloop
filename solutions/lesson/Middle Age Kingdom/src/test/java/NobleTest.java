import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NobleTest {
    @Test
    public void testTax() {
        Inhabitant noble = new Noble();
        noble.setIncome(199);
        assertEquals("Noble.tax() should respect the royal instruction 4!", 20, noble.tax());

        noble.setIncome(0);
        assertEquals("Noble.tax() should respect the royal instruction 4!", 20, noble.tax());

        noble.setIncome(210);
        assertEquals("Noble.tax() should return the tax value correctly!", 21, noble.tax());

        noble.setIncome(300);
        assertEquals("Noble.tax() should return the tax value correctly!", 30, noble.tax());

        noble.setIncome(305);
        assertEquals("Noble.tax() should return the tax value correctly!", 30, noble.tax());
    }
}
