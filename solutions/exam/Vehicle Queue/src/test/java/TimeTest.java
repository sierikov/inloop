import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
    private Time t;

    @Before
    public void setUp() throws IllegalArgumentException, IllegalAccessException, InstantiationException,
            InvocationTargetException {
        /*
         * Re-initialize singleton instance so the tests can be performed under equal conditions
         */
        try {
            Constructor<Time> c = Time.class.getDeclaredConstructor();
            c.setAccessible(true);
            Field f = Time.class.getDeclaredField("instance");
            f.setAccessible(true);
            f.set(null, c.newInstance());
        } catch (NoSuchFieldException e) {
            fail("The class Time should have an attribute named instance for the singleton pattern!");
        } catch (NoSuchMethodException e) {
            fail("The class Time should have a private constructor without any parameters!");
        }

        t = Time.getInstance();
    }

    @Test
    public void testSingleton() throws NoSuchMethodException {
        Method m = Time.class.getMethod("getInstance");
        assertTrue("Time.getInstance() should be public!", Modifier.isPublic(m.getModifiers()));
        assertTrue("Time.getInstance() should be static!", Modifier.isStatic(m.getModifiers()));
        assertTrue(
                "The class Time should be a singleton so there cannot be two different instances at the same time!",
                t == Time.getInstance());
    }

    @Test
    public void testImplementsObservable() {
        assertTrue("The class Time should implement java.util.Observable!",
                Observable.class.isAssignableFrom(Time.class));
    }

    @Test
    public void testDefaultValues() {
        assertEquals("Time.currentTime should be initialized with the value 0!", 0, t.getCurrentTime());
        t.run();
        assertEquals("Time.endofTime should be initialized with the value 100!", 100, t.getCurrentTime());
    }

    @Test
    public void testInitEndOfTimeIllegalArgument() {
        try {
            t.initEndOfTime(-1);
            fail("Time.initEndOfTime() should throw an IllegalArgumentException if the argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testInitEndOfTime() {
        t.initEndOfTime(70);
        t.run();
        assertEquals("Time.initEndOfTime() should set endOfTime correctly!", 70, t.getCurrentTime());
        t.initEndOfTime(5);
        t.run();
        assertEquals("Time.initEndOfTime() should set endOfTime correctly!", 5, t.getCurrentTime());
    }

    @Test
    public void testRun() {
        final Set<Integer> seconds = new HashSet<>();
        Observer observer = new Observer() {
            @Override
            public void update(Observable obs, Object obj) {
                assertTrue("Time.run() should not notify its observers more than once per simulated second!",
                        seconds.add(((Time) obs).getCurrentTime()));
            }
        };
        t.initEndOfTime(200);
        t.addObserver(observer);
        t.run();

        assertFalse(
                "Time.run() should not notify its observers when no second has passed, i.e. Time.getCurrentTime() == 0!",
                seconds.remove(0)
        );

        for (int i = 1; i <= 200; i++) {
            assertTrue("Time.run() should notify its observers of every second that has passed!",
                    seconds.remove(i)
            );
        }
        assertTrue("Time.run() should not notify its observers of any seconds after Time.endOfTime!",
                seconds.isEmpty()
        );
    }
}
