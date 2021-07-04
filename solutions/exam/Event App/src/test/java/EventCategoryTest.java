import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EventCategoryTest {
	@Test
	public void testSize() {
		assertEquals("EventCategory should contain exactly three enum literals!", 3, EventCategory.values().length);
	}

	@Test
	public void testOrder() {
		assertTrue("Enum literal EXHIBITION should be declared before PRESENTATION!",
				EventCategory.EXHIBITION.compareTo(EventCategory.PRESENTATION) < 0);
		assertTrue("Enum literal PRESENTATION should be declared before SHOW!",
				EventCategory.PRESENTATION.compareTo(EventCategory.SHOW) < 0);
	}
}
