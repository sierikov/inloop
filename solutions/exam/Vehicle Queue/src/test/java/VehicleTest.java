import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;

import org.junit.Test;

public class VehicleTest {
    @Test
    public void testVehicleAbstract() {
        assertTrue("The class Vehicle should be abstract!", Modifier.isAbstract(Vehicle.class.getModifiers()));
        assertTrue("The class Vehicle should be an abstract class, not an interface!",
                !Vehicle.class.isInterface());
        try {
            assertTrue("Vehicle.getLength() should be abstract!",
                    Modifier.isAbstract(Vehicle.class.getMethod("getLength").getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("The class Vehicle should have a public method getLength()!");
        }
    }

    @Test
    public void testBicycle() {
        assertEquals("Bicycle.getLength() should return the correct value!", 1.5, new Bicycle().getLength(), 0);
    }

    @Test
    public void testBus() {
        assertEquals("Bus.getLength() should return the correct value!", 18.0, new Bus().getLength(), 0);
    }

    @Test
    public void testCar() {
        assertEquals("Car.getLength() should return the correct value!", 6.0, new Car().getLength(), 0);
    }
}
