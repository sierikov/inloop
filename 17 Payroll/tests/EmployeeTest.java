import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.Test;

public class EmployeeTest {
    private static class EmployeeImpl extends Employee {
        public EmployeeImpl(String id) {
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
        } catch (NoSuchMethodException e) {
            fail("Employee should have a method named isPayday with one parameter of type int!");
        }
        try {
            assertTrue("Employee.calculatePay() should be abstract!",
                    Modifier.isAbstract(Employee.class.getDeclaredMethod("calculatePay").getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("Employee should have a method named calculatePay without any parameters!");
        }
        try {
            assertTrue("Employee.calculateDeductions() should be abstract!",
                    Modifier.isAbstract(Employee.class.getDeclaredMethod("calculateDeductions").getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("Employee should have a method named calculateDeductions without any parameters!");
        }
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new EmployeeImpl(null);
            fail("Employee.Employee() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Appointee(null, 1, 1, 1);
            fail("Appointee.Appointee() should throw a NullPointerException if the id argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Volunteer(null);
            fail("Volunteer.Volunteer() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new EmployeeImpl("");
            fail("Employee.Employee() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Appointee("", 1, 1, 1);
            fail("Appointee.Appointee() should throw an IllegalArgumentException if the id argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Volunteer("");
            fail("Volunteer.Volunteer() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetId() {
        Employee e = new EmployeeImpl("Martin");
        assertTrue("Employee.getId() should return the correct value!", e.getId().equals("Martin"));

        e = new Appointee("Eric", 1, 1, 1);
        assertTrue("Appointee.getId() should return the correct value!", e.getId().equals("Eric"));

        e = new Volunteer("Michael");
        assertTrue("Volunteer.getId() should return the correct value!", e.getId().equals("Michael"));
    }

    @Test
    public void testCalculatePayThrowsDeclaration() {
        try {
            assertTrue("Employee.calculatePay() should declare to throw UnpayableEmployeeException!",
                    Arrays.asList(Employee.class.getDeclaredMethod("calculatePay").getExceptionTypes())
                            .contains(UnpayableEmployeeException.class));
        } catch (NoSuchMethodException e) {
            fail("Employee should have a method named calculatePay without any parameters!");
        }
    }
}
