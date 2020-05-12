import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NobleTest {
    @Test
    public void testTax() {
        Inhabitant n = new Noble();
        n.setIncome(199);
        assertEquals("Noble.tax() should respect the royal instruction 4!", 20, n.tax());

        n.setIncome(0);
        assertEquals("Noble.tax() should respect the royal instruction 4!", 20, n.tax());

        n.setIncome(-1);
        assertEquals("Noble.tax() should respect the royal instruction 4!", 20, n.tax());

        n.setIncome(210);
        assertEquals("Noble.tax() should return the tax value correctly!", 21, n.tax());

        n.setIncome(300);
        assertEquals("Noble.tax() should return the tax value correctly!", 30, n.tax());

        n.setIncome(305);
        assertEquals("Noble.tax() should return the tax value correctly!", 30, n.tax());
    }
}
