import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class LeetTest {
    private static String[] org = new String[] { "elite", "cool", "!", "ck", "ers", "er", "en", "e", "t", "o", "a", };
    private static String[] res = new String[] { "1337", "k3wl", "!!!11", "xx", "0rz", "0rz", "n", "3", "7", "0", "@", };
    private static String[] orgText = new String[] { "We are elite hackers!", "Informatiker machen tolle Sachen!" };
    private static String[] resText = new String[] { "W3 @r3 1337 h@xx0rz!!!11",
            "Inf0rm@7ik0rz m@chn 70ll3 S@chn!!!11" };
    private static String[] orgRightOrderText = new String[] {"eliters cool ers er en"};
    private static String[] resRightOrderText = new String[] {"1337rs k3wl 0rz 0rz n"};

    @Test
    public void testMethodsAreStatic() {
        Method m = null;
        try {
            m = Leet.class.getDeclaredMethod("toLeet", String.class);
        } catch (NoSuchMethodException e) {
            Assert.fail("The class Leet should have a method named toLeet with one parameter of type String!");
        }
        assertTrue("The method Leet.toLeet() should be public!", Modifier.isPublic(m.getModifiers()));
        assertTrue("The method Leet.toLeet() should be static!", Modifier.isStatic(m.getModifiers()));
        assertSame("The return type of Leet.toLeet() should be String!", String.class, m.getReturnType());

        try {
            m = Leet.class.getDeclaredMethod("allToLeet", String[].class);
        } catch (NoSuchMethodException e) {
            Assert.fail("The class Leet should have a method named allToLeet with one parameter of type String[]!");
        }
        assertTrue("The method Leet.allToLeet() should be public!", Modifier.isPublic(m.getModifiers()));
        assertTrue("The method Leet.allToLeet() should be static!", Modifier.isStatic(m.getModifiers()));
        assertSame("The return type of Leet.allToLeet() should be String[]!", String[].class, m.getReturnType());
    }

    @Test
    public void testToLeet() {
        for (int i = 0; i < org.length; i++) {
            assertEquals("Leet.toLeet() should translate strings according to the table in the task description!",
                    res[i], Leet.toLeet(org[i]));
        }
        for (int i = 0; i < orgText.length; i++) {
            assertEquals("Leet.toLeet() should translate strings according to the table in the task description!",
                    resText[i], Leet.toLeet(orgText[i]));
        }
    }

    @Test
    public void testAllToLeet() {
        String[] actual = Leet.allToLeet(org);
        String[] actualText = Leet.allToLeet(orgText);

        assertTrue(
                "Leet.allToLeet(String[]): This method should not write into the parameter array but instead create a new one.",
                actualText != orgText);
        assertTrue(
                "Leet.allToLeet(String[]): Returned array must have the same length as the array passed to the method.",
                orgText.length == actualText.length);

        for (int i = 0; i < org.length; i++) {
            assertEquals(
                    "Leet.allToLeet() should translate strings in String arrays according to the task description!",
                    res[i], actual[i]);
        }
        for (int i = 0; i < orgText.length; i++) {
            assertEquals(
                    "Leet.allToLeet() should translate strings in String arrays according to the task description!",
                    resText[i], actualText[i]);
        }
    }

    @Test
    public void testOrderOfTransformation() {
        String[] actualOrder = Leet.allToLeet(orgRightOrderText);

        assertEquals("The order of your transformations is incorrect! Please look in the table of the task for the right order.",
                resRightOrderText[0], actualOrder[0]);
    }
}
