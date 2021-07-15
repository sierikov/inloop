import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ClockTest {
    private Clock clock;
    private MockObserver mock;

    @Before
    public void setUp() {
        clock = new Clock(10);
        mock = new MockObserver();
    }

    @Test
    public void testInitialValue() {
        assertEquals("Clock.currentTime should be initialized with the value 0!", 0, clock.getCurrentTime());
    }

    @Test
    public void testEndOfTimeIllegalArgument() {
        try {
            new Clock(-1);
            fail("new Clock(…) should throw an IllegalArgumentException if the argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testInitEndOfTime() {
        clock.run();
        assertEquals("new Clock(…) should set endOfTime correctly!", 10, clock.getCurrentTime());
    }

    @Test
    public void testRun() {
        MockObserver anotherMock = new MockObserver();
        clock.addObserver(mock);
        clock.addObserver(anotherMock);
        clock.run();
        List<Integer> expectedArgs = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        String message = "Clock.run() should notify each observer once for every second from 1 to endOfTime!";
        assertEquals(message, expectedArgs, mock.getArguments());
        assertEquals(message, expectedArgs, anotherMock.getArguments());
    }

    @Test
    public void testRunTwice() {
        clock.addObserver(mock);
        clock.run();
        clock.run();
        assertEquals("Clock.run() should also work when used more than once!", 20, mock.getNumOfCalls());
        assertEquals("Clock.run() should start with currentTime set to zero!", 10, clock.getCurrentTime());
    }

    @Test
    public void testRemoveObserver() {
        clock.addObserver(mock);
        clock.removeObserver(mock);
        clock.run();
        assertEquals("Removed observers should not be notified during Clock.run()!", 0, mock.getNumOfCalls());
    }

    /**
     * Mock implementation for testing purposes. In practice, you would use a library such as Mockito.
     */
    private static class MockObserver implements ClockObserver {
        private List<Integer> ticks = new ArrayList<>();

        @Override
        public void tick(int currentTime) {
            ticks.add(currentTime);
        }

        public int getNumOfCalls() {
            return ticks.size();
        }

        public List<Integer> getArguments() {
            return List.copyOf(ticks);
        }
    }
}
