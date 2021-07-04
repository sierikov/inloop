import org.junit.Test;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.*;

public class EmployeeTest {
    private static class EmployeeImpl extends Employee {
        EmployeeImpl(String id) {
            super(id);
        }

        @Override
        public boolean isPayday(int dayOfMonth) {
            return false;
        }

        @Override
        public double calculatePay() throws UnpayableEmployeeException {
            return 0;
        }

        @Override
        public double calculateDeductions() {
            return 0;
        }
    }

    @Test
    public void testAbstract() {
        assertTrue("Employee should be abstract!", Modifier.isAbstract(Employee.class.getModifiers()));
        try {
            assertTrue("Employee.isPayday() should be abstract!",
                    Modifier.isAbstract(Employee.class.getDeclaredMethod("isPayday", int.class).getModifiers()));
        } catch (NoSuchMethodException exception) {
            fail("Employee should have a method named isPayday with one parameter of type int!");
        }
        try {
            assertTrue("Employee.calculatePay() should be abstract!",
                    Modifier.isAbstract(Employee.class.getDeclaredMethod("calculatePay").getModifiers()));
        } catch (NoSuchMethodException exception) {
            fail("Employee should have a method named calculatePay without any parameters!");
        }
        try {
            assertTrue("Employee.calculateDeductions() should be abstract!",
                    Modifier.isAbstract(Employee.class.getDeclaredMethod("calculateDeductions").getModifiers()));
        } catch (NoSuchMethodException exception) {
            fail("Employee should have a method named calculateDeductions without any parameters!");
        }
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new EmployeeImpl(null);
            fail("Employee.Employee() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException exception) {
            // NullPointerException correctly thrown
        }

        try {
            new Appointee(null, 1, 1, 1);
            fail("Appointee.Appointee() should throw a NullPointerException if the id argument is null!");
        } catch (NullPointerException exception) {
            // NullPointerException correctly thrown
        }

        try {
            new Volunteer(null);
            fail("Volunteer.Volunteer() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException exception) {
            // NullPointerException correctly thrown
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new EmployeeImpl("");
            fail("Employee.Employee() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException exception) {
            // IllegalArgumentException correctly thrown
        }

        try {
            new Appointee("", 1, 1, 1);
            fail("Appointee.Appointee() should throw an IllegalArgumentException if the id argument is empty!");
        } catch (IllegalArgumentException exception) {
            // IllegalArgumentException correctly thrown
        }

        try {
            new Volunteer("");
            fail("Volunteer.Volunteer() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException exception) {
            // IllegalArgumentException correctly thrown
        }
    }

    @Test
    public void testGetId() {
        Employee e = new EmployeeImpl("Martin");
        assertEquals("Employee.getId() should return the correct value!", "Martin", e.getId());

        e = new Appointee("Eric", 1, 1, 1);
        assertEquals("Appointee.getId() should return the correct value!", "Eric", e.getId());

        e = new Volunteer("Michael");
        assertEquals("Volunteer.getId() should return the correct value!", "Michael", e.getId());
    }

    @Test
    public void testCalculatePayThrowsDeclaration() {
        try {
            assertTrue("Employee.calculatePay() should declare to throw UnpayableEmployeeException!",
                    Arrays.asList(Employee.class.getDeclaredMethod("calculatePay").getExceptionTypes())
                            .contains(UnpayableEmployeeException.class));
        } catch (NoSuchMethodException exception) {
            fail("Employee should have a method named calculatePay without any parameters!");
        }
    }
}
