import org.junit.Test;

import static org.junit.Assert.*;

public class StockObserverTest {
    @Test
    public void testInterface(){
        assertTrue(StockObserver.class.isInterface());
    }
}