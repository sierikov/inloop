import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KingTest {
    @Test
    public void testTax() {
        Inhabitant king = new King();

        king.setIncome(10);
        assertEquals("King.tax() should return the correct tax value for the king!", 0, king.tax());

        king.setIncome(0);
        assertEquals("King.tax() should return the correct tax value for the king!", 0, king.tax());

        king.setIncome(20);
        assertEquals("King.tax() should return the correct tax value for the king!", 0, king.tax());
    }
}
