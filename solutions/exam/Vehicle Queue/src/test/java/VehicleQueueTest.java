import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.BeforeClass;
import org.junit.Test;

public class VehicleQueueTest {
    private static List<VehicleQueueTestData> testDataList;

    @Test
    public void testImplementsObserver() {
        assertTrue("The class VehicleQueue should implement ClockObserver!",
                ClockObserver.class.isAssignableFrom(VehicleQueue.class));
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new VehicleQueue(0.5, 0.25, 20, null);
            fail("VehicleQueue.VehicleQueue() should throw a NullPointerException if the generator argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new VehicleQueue(0, 1, 20, new VehicleGenerator());
            fail("VehicleQueue.VehicleQueue() should throw an IllegalArgumentException if the entryDelay argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new VehicleQueue(-Double.MIN_VALUE, 1, 20, new VehicleGenerator());
            fail("VehicleQueue.VehicleQueue() should throw an IllegalArgumentException if the entryDelay argument is negative!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new VehicleQueue(1, 0, 20, new VehicleGenerator());
            fail("VehicleQueue.VehicleQueue() should throw an IllegalArgumentException if the exitDelay argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new VehicleQueue(1, -Double.MIN_VALUE, 20, new VehicleGenerator());
            fail("VehicleQueue.VehicleQueue should throw an IllegalArgumentException if the exitDelay argument is negative!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new VehicleQueue(1, 1, 0, new VehicleGenerator());
            fail("VehicleQueue.VehicleQueue() should throw an IllegalArgumentException if the trafficLightRate argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new VehicleQueue(0.5, 1, -1, new VehicleGenerator());
            fail("VehicleQueue.VehicleQueue() should throw an IllegalArgumentException if the trafficLightRate argument is is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testEnterAndLeave() {
        VehicleQueue queue = new VehicleQueue(1, 1, 5, new VehicleGenerator());
        assertEquals("VehicleQueue.getSize() should return 0 after initialization!", 0, queue.getSize());
        queue.enter();
        assertEquals("VehicleQueue.enter() should increase the size of the queue!", 1, queue.getSize());
        queue.enter();
        queue.enter();
        assertEquals("VehicleQueue.enter() should increase the size of the queue!", 3, queue.getSize());
        queue.leave();
        assertEquals("VehicleQueue.leave() should decrease the size of the queue!", 2, queue.getSize());
        queue.leave();
        queue.leave();
        assertEquals("VehicleQueue.leave() should decrease size of the queue!", 0, queue.getSize());
        queue.leave();
        assertEquals("VehicleQueue.leave() should not change the size of the queue if it is empty!", 0,
                queue.getSize());
    }

    @Test
    public void testLength() {
        final List<Vehicle> vehiclesToProvide = new ArrayList<>(Arrays.asList(new Vehicle[] { new Bus(), new Car(),
                new Bus(), new Bicycle(), new Bicycle(), new Car(), new Bus(), new Car(), null }));
        VehicleQueue queue = new VehicleQueue(1, 1, 5, new VehicleGenerator() {
            @Override
            public Vehicle createVehicle() {
                Objects.requireNonNull(vehiclesToProvide.get(0),
                        "VehicleGenerator.createVehicle() should only be called once per call to VehicleQueue.enter()!");
                /* Re-add the next Vehicle and return it */
                vehiclesToProvide.add(vehiclesToProvide.get(0));
                return vehiclesToProvide.remove(0);
            }
        });
        double currentLength = 0;
        /* Loop through the list. The end of the list is marked by the 'null' entry. */
        while (vehiclesToProvide.get(0) != null) {
            currentLength += vehiclesToProvide.get(0).getLength();
            queue.enter();
            assertEquals("VehicleQueue.getLength() should return the correct value!", currentLength,
                    queue.getLength(), 0.0001);
        }
        /* Remove the null entry */
        vehiclesToProvide.remove(0);
        /*
         * Loop through the list, again. This time the list elements are removed so the end of the list is reached when
         * the list is empty.
         */
        while (!vehiclesToProvide.isEmpty()) {
            currentLength -= vehiclesToProvide.get(0).getLength();
            vehiclesToProvide.remove(0);
            queue.leave();
            assertEquals("VehicleQueue.getLength() should return the correct value!", currentLength,
                    queue.getLength(), 0.0001);
        }
    }

    @Test
    public void testTick() {
        for (VehicleQueueTestData testData : testDataList) {
            VehicleQueue queue = new VehicleQueue(testData.getEntryDelay(), testData.getExitDelay(),
                    testData.getTrafficLightRate(), new VehicleGenerator());
            for (int time = 1; time <= testData.getQueueSizeValues().length; time++) {
                queue.tick(time);
                assertEquals(
                        "VehicleQueue.tick(…) should change the size of the queue correctly!\n"
                                + "If you want to know the exact point where it failed, have a look at the source code of this JUnit test.\n"
                                + "The test failed at queueSizeValue no. " + time + " of test data set no. "
                                + (testDataList.indexOf(testData) + 1)
                                + ".\nYou can find the test data sets in the method VehicleQueueTest.setUpTestData().",
                        testData.getQueueSizeValues()[time - 1], queue.getSize());
            }
        }
    }

    @BeforeClass
    public static void setUpTestData() {
        int[] queueSizeValues;
        testDataList = new ArrayList<VehicleQueueTestData>();

        queueSizeValues = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 20,
                20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 22, 23, 24, 25, 26, 27,
                28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40,
                40, 40, 40, 40, 40, 40, 40, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
                58, 59, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 61, 62,
                63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 80, 80, 80, 80, 80, 80, 80,
                80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92,
                93, 94, 95, 96, 97, 98, 99, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114,
                115, 116, 117, 118, 119, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120,
                120, 120, 120, 120, 120, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134,
                135, 136, 137, 138, 139, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140,
                140, 140, 140, 140, 140, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154,
                155, 156, 157, 158, 159, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160 };
        testDataList.add(new VehicleQueueTestData(1, 1, 20, queueSizeValues));

        queueSizeValues = new int[] { 0, 1, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 4, 4, 5, 6, 6, 7, 8,
                8, 9, 10, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 7, 8, 8, 9, 10, 10, 11, 12, 12, 13, 13, 12, 12, 12, 11, 11,
                11, 10, 10, 10, 10, 11, 12, 12, 13, 14, 14, 15, 16, 16, 16, 16, 15, 15, 15, 14, 14, 14, 13, 13, 14,
                14, 15, 16, 16, 17, 18, 18, 19, 20, 19, 19, 19, 18, 18, 18, 17, 17, 17, 16, 17, 18, 18, 19, 20, 20,
                21, 22, 22, 23, 23, 22, 22, 22, 21, 21, 21, 20, 20, 20, 20, 21, 22, 22, 23, 24, 24, 25, 26, 26, 26,
                26, 25, 25, 25, 24, 24, 24, 23, 23, 24, 24, 25, 26, 26, 27, 28, 28, 29, 30, 29, 29, 29, 28, 28, 28,
                27, 27, 27, 26, 27, 28, 28, 29, 30, 30, 31, 32, 32, 33, 33, 32, 32, 32, 31, 31, 31, 30, 30, 30, 30,
                31, 32, 32, 33, 34, 34, 35, 36, 36, 36, 36, 35, 35, 35, 34, 34, 34, 33, 33, 34, 34, 35, 36, 36, 37,
                38, 38, 39, 40, 39, 39, 39, 38, 38, 38, 37, 37, 37, 36, 37, 38, 38, 39, 40, 40, 41, 42, 42, 43, 43,
                42, 42, 42, 41, 41, 41, 40, 40, 40, 40, 41, 42, 42, 43, 44, 44, 45, 46, 46, 46, 46, 45, 45, 45, 44,
                44, 44, 43, 43, 44, 44, 45, 46, 46, 47, 48, 48, 49, 50, 49, 49, 49, 48, 48, 48, 47, 47, 47, 46, 47,
                48, 48, 49, 50, 50, 51, 52, 52, 53, 53, 52, 52, 52, 51, 51, 51, 50, 50, 50, 50, 51, 52, 52, 53, 54,
                54, 55, 56, 56 };
        testDataList.add(new VehicleQueueTestData(1.5, 1, 10, queueSizeValues));

        queueSizeValues = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 11, 12, 12, 12, 13, 13, 13, 14, 15, 16,
                17, 18, 19, 20, 21, 22, 23, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 29, 30, 31, 32, 33, 34, 35,
                36, 37, 38, 39, 39, 39, 40, 40, 40, 41, 41, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 53,
                53, 54, 54, 54, 55, 55, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 67, 67, 68, 68, 68, 69,
                69, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 81, 81, 82, 82, 82, 83, 83, 83, 84, 85, 86,
                87, 88, 89, 90, 91, 92, 93, 94, 95, 95, 95, 96, 96, 96, 97, 97, 97, 98, 99, 100, 101, 102, 103, 104,
                105, 106, 107, 108, 109, 109, 109, 110, 110, 110, 111, 111, 111, 112, 113, 114, 115, 116, 117, 118,
                119, 120, 121, 122, 123, 123, 123, 124, 124, 124, 125, 125, 125, 126, 127, 128, 129, 130, 131, 132,
                133, 134, 135, 136, 137, 137, 137, 138, 138, 138, 139, 139, 139, 140, 141, 142, 143, 144, 145, 146,
                147, 148, 149, 150, 151, 151, 151, 152, 152, 152, 153, 153, 153, 154, 155, 156, 157, 158, 159, 160,
                161, 162, 163, 164, 165, 165, 165, 166, 166, 166, 167, 167, 167, 168, 169, 170, 171, 172, 173, 174,
                175, 176, 177, 178, 179, 179, 179, 180, 180, 180, 181, 181, 181, 182, 183, 184, 185, 186, 187, 188,
                189, 190, 191, 192, 193, 193, 193, 194, 194, 194, 195, 195, 195, 196, 197, 198, 199, 200, 201, 202,
                203, 204, 205, 206, 207, 207, 207, 208, 208, 208, 209, 209, 209, 210, 211, 212, 213, 214, 215, 216,
                217, 218, 219, 220 };
        testDataList.add(new VehicleQueueTestData(1, 1.5, 10, queueSizeValues));

        queueSizeValues = new int[] { 0, 1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6, 5, 5, 4, 4, 5, 4, 4, 3, 4, 4, 5, 6, 6, 7, 7,
                8, 9, 9, 10, 9, 9, 9, 8, 8, 8, 8, 7, 7, 8, 8, 9, 9, 10, 11, 11, 12, 12, 13, 14, 13, 13, 12, 12, 11,
                12, 12, 11, 11, 11, 12, 13, 13, 14, 14, 15, 16, 16, 17, 17, 17, 16, 16, 16, 15, 16, 15, 15, 15, 15,
                16, 16, 17, 18, 18, 19, 19, 20, 20, 21, 21, 20, 20, 19, 19, 20, 19, 19, 18, 19, 20, 20, 21, 21, 22,
                22, 23, 24, 24, 25, 24, 24, 24, 23, 23, 23, 23, 23, 22, 23, 23, 24, 24, 25, 26, 26, 27, 27, 28, 29,
                28, 28, 27, 27, 27, 27, 27, 26, 26, 26, 27, 28, 28, 29, 29, 30, 31, 31, 32, 32, 32, 32, 31, 31, 30,
                31, 30, 30, 30, 30, 31, 31, 32, 33, 33, 34, 34, 35, 36, 36, 36, 35, 35, 34, 34, 35, 34, 34, 33, 34,
                35, 35, 36, 36, 37, 38, 38, 39, 39, 40, 39, 39, 39, 38, 38, 38, 38, 38, 37, 38, 38, 39, 40, 40, 41,
                41, 42, 42, 43, 44, 43, 43, 42, 42, 42, 42, 42, 41, 41, 42, 42, 43, 43, 44, 44, 45, 46, 46, 47, 47,
                47, 47, 46, 46, 45, 46, 46, 45, 45, 45, 46, 46, 47, 48, 48, 49, 49, 50, 51, 51, 51, 50, 50, 50, 49,
                50, 49, 49, 48, 49, 50, 50, 51, 51, 52, 53, 53, 54, 54, 55, 55, 54, 54, 53, 53, 53, 53, 53, 52, 53,
                53, 54, 55, 55, 56, 56, 57, 58, 58, 59, 58, 58, 57, 57, 57, 57, 57, 56, 56, 57, 57, 58, 58, 59, 60,
                60, 61, 61, 62 };
        testDataList.add(new VehicleQueueTestData(1.7, 1.2, 10, queueSizeValues));

        queueSizeValues = new int[] { 0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9, 9, 9, 10, 10, 10, 11, 10, 11, 12, 13, 14,
                15, 15, 16, 17, 18, 19, 20, 20, 20, 21, 21, 22, 22, 21, 22, 22, 23, 24, 25, 25, 26, 27, 28, 29, 30,
                30, 31, 32, 32, 33, 33, 33, 33, 33, 34, 34, 35, 35, 36, 37, 38, 39, 40, 40, 41, 42, 43, 44, 44, 44,
                44, 45, 45, 45, 46, 45, 46, 47, 48, 49, 50, 50, 51, 52, 53, 54, 55, 55, 55, 56, 56, 57, 57, 56, 57,
                57, 58, 59, 60, 60, 61, 62, 63, 64, 65, 65, 66, 67, 67, 68, 68, 68, 68, 68, 69, 69, 70, 70, 71, 72,
                73, 74, 75, 75, 76, 77, 78, 79, 79, 79, 79, 80, 80, 80, 81, 80, 81, 82, 83, 84, 85, 85, 86, 87, 88,
                89, 90, 90, 90, 91, 91, 92, 92, 91, 92, 92, 93, 94, 95, 95, 96, 97, 98, 99, 100, 100, 101, 102, 102,
                103, 103, 103, 103, 103, 104, 104, 105, 105, 106, 107, 108, 109, 110, 110, 111, 112, 113, 114, 114,
                114, 114, 115, 115, 115, 116, 115, 116, 117, 118, 119, 120, 120, 121, 122, 123, 124, 125, 125, 125,
                126, 126, 127, 127, 126, 127, 127, 128, 129, 130, 130, 131, 132, 133, 134, 135, 135, 136, 137, 137,
                138, 138, 138, 138, 138, 139, 139, 140, 140, 141, 142, 143, 144, 145, 145, 146, 147, 148, 149, 149,
                149, 149, 150, 150, 150, 151, 150, 151, 152, 153, 154, 155, 155, 156, 157, 158, 159, 160, 160, 160,
                161, 161, 162, 162, 161, 162, 162, 163, 164, 165, 165, 166, 167, 168, 169, 170, 170, 171, 172, 172,
                173, 173, 173, 173, 173, 174, 174, 175, 175, 176, 177, 178, 179, 180, 180, 181, 182, 183 };
        testDataList.add(new VehicleQueueTestData(1.2, 1.7, 10, queueSizeValues));

        queueSizeValues = new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 12, 14, 14, 15, 15, 16, 16, 16, 17, 17, 18, 18, 20,
                21, 22, 24, 25, 27, 28, 30, 31, 32, 33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 38, 40, 41, 42, 44, 45,
                47, 48, 50, 51, 51, 52, 52, 53, 53, 54, 54, 54, 55, 55, 57, 58, 60, 61, 62, 64, 65, 67, 68, 70, 70,
                70, 71, 71, 72, 72, 73, 73, 73, 74, 75, 77, 78, 80, 81, 82, 84, 85, 87, 88, 89, 89, 89, 90, 90, 91,
                91, 92, 92, 92, 94, 95, 97, 98, 100, 101, 102, 104, 105, 107, 107, 108, 108, 108, 109, 109, 110, 110,
                111, 111, 112, 114, 115, 117, 118, 120, 121, 122, 124, 125, 126, 126, 127, 127, 127, 128, 128, 129,
                129, 130, 131, 132, 134, 135, 137, 138, 140, 141, 142, 144, 144, 145, 145, 146, 146, 146, 147, 147,
                148, 148, 150, 151, 152, 154, 155, 157, 158, 160, 161, 162, 163, 163, 164, 164, 165, 165, 165, 166,
                166, 167, 168, 170, 171, 172, 174, 175, 177, 178, 180, 181, 181, 182, 182, 183, 183, 184, 184, 184,
                185, 185, 187, 188, 190, 191, 192, 194, 195, 197, 198, 200, 200, 200, 201, 201, 202, 202, 203, 203,
                203, 204, 205, 207, 208, 210, 211, 212, 214, 215, 217, 218, 219, 219, 219, 220, 220, 221, 221, 222,
                222, 222, 224, 225, 227, 228, 230, 231, 232, 234, 235, 237, 237, 238, 238, 238, 239, 239, 240, 240,
                241, 241, 242, 244, 245, 247, 248, 250, 251, 252, 254, 255, 256, 256, 257, 257, 257, 258, 258, 259,
                259, 260, 261, 262, 264, 265, 267, 268, 270, 271, 272, 274, 274, 275, 275, 276, 276, 276, 277, 277,
                278, 278, 280, 281, 282, 284, 285, 287, 288, 290, 291, 292 };
        testDataList.add(new VehicleQueueTestData(0.7, 1, 10, queueSizeValues));

        queueSizeValues = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 9, 9, 8, 8, 7, 7, 7, 6, 7, 8, 9, 10, 11,
                12, 13, 14, 15, 16, 16, 16, 15, 15, 14, 14, 13, 13, 13, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                22, 22, 21, 21, 20, 20, 19, 19, 19, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 28, 28, 27, 27, 26,
                26, 25, 25, 25, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 34, 34, 33, 33, 32, 32, 31, 31, 31, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 40, 40, 39, 39, 38, 38, 37, 37, 37, 36, 37, 38, 39, 40, 41,
                42, 43, 44, 45, 46, 46, 46, 45, 45, 44, 44, 43, 43, 43, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52,
                52, 52, 51, 51, 50, 50, 49, 49, 49, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 58, 58, 57, 57, 56,
                56, 55, 55, 55, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 64, 64, 63, 63, 62, 62, 61, 61, 61, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 70, 70, 69, 69, 68, 68, 67, 67, 67, 66, 67, 68, 69, 70, 71,
                72, 73, 74, 75, 76, 76, 76, 75, 75, 74, 74, 73, 73, 73, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82,
                82, 82, 81, 81, 80, 80, 79, 79, 79, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 88, 88, 87, 87, 86,
                86, 85, 85, 85, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 94, 94, 93, 93, 92, 92, 91, 91, 91, 90,
                91, 92, 93, 94, 95, 96, 97, 98, 99, 100 };
        testDataList.add(new VehicleQueueTestData(1, 0.7, 10, queueSizeValues));

        queueSizeValues = new int[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 54, 58, 61, 65, 68, 72, 75, 79, 83, 86,
                91, 96, 101, 106, 111, 116, 121, 126, 131, 136, 140, 144, 147, 151, 154, 158, 161, 165, 169, 172, 177,
                182, 187, 192, 197, 202, 207, 212, 217, 222, 226, 230, 233, 237, 240, 244, 247, 251, 255, 258, 263,
                268, 273, 278, 283, 288, 293, 298, 303, 308, 312, 316, 319, 323, 326, 330, 333, 337, 341, 344, 349,
                354, 359, 364, 369, 374, 379, 384, 389, 394, 398, 402, 405, 409, 412, 416, 419, 423, 427, 430, 435,
                440, 445, 450, 455, 460, 465, 470, 475, 480, 484, 488, 491, 495, 498, 502, 505, 509, 513, 516, 521,
                526, 531, 536, 541, 546, 551, 556, 561, 566, 570, 574, 577, 581, 584, 588, 591, 595, 599, 602, 607,
                612, 617, 622, 627, 632, 637, 642, 647, 652, 656, 660, 663, 667, 670, 674, 677, 681, 685, 688, 693,
                698, 703, 708, 713, 718, 723, 728, 733, 738, 742, 746, 749, 753, 756, 760, 763, 767, 771, 774, 779,
                784, 789, 794, 799, 804, 809, 814, 819, 824, 828, 832, 835, 839, 842, 846, 849, 853, 857, 860, 865,
                870, 875, 880, 885, 890, 895, 900, 905, 910, 914, 918, 921, 925, 928, 932, 935, 939, 943, 946, 951,
                956, 961, 966, 971, 976, 981, 986, 991, 996, 1000, 1004, 1007, 1011, 1014, 1018, 1021, 1025, 1029,
                1032, 1037, 1042, 1047, 1052, 1057, 1062, 1067, 1072, 1077, 1082, 1086, 1090, 1093, 1097, 1100, 1104,
                1107, 1111, 1115, 1118, 1123, 1128, 1133, 1138, 1143, 1148, 1153, 1158, 1163, 1168, 1172, 1176, 1179,
                1183, 1186, 1190, 1193, 1197, 1201, 1204, 1209, 1214, 1219, 1224, 1229, 1234, 1239, 1244, 1249, 1254,
                1258, 1262, 1265, 1269, 1272, 1276, 1279, 1283, 1287, 1290, 1295, 1300, 1305, 1310, 1315, 1320, 1325,
                1330, 1335, 1340 };
        testDataList.add(new VehicleQueueTestData(0.2, 0.7, 10, queueSizeValues));

        queueSizeValues = new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 12, 14, 10, 7, 3, 0, 0, 0, 0, 0, 0, 0, 2, 3, 4, 6, 7,
                9, 10, 12, 13, 14, 11, 7, 4, 0, 0, 0, 0, 0, 0, 0, 1, 3, 4, 5, 7, 8, 10, 11, 13, 14, 10, 7, 3, 0, 0, 0,
                0, 0, 0, 0, 2, 3, 5, 6, 7, 9, 10, 12, 13, 15, 11, 7, 4, 0, 0, 0, 0, 0, 0, 0, 1, 3, 4, 6, 7, 8, 10, 11,
                13, 14, 11, 7, 3, 0, 0, 0, 0, 0, 0, 0, 2, 3, 5, 6, 8, 9, 10, 12, 13, 15, 11, 8, 4, 0, 0, 0, 0, 0, 0,
                0, 1, 3, 4, 6, 7, 9, 10, 11, 13, 14, 11, 7, 4, 0, 0, 0, 0, 0, 0, 0, 1, 2, 4, 5, 7, 8, 10, 11, 12, 14,
                10, 7, 3, 0, 0, 0, 0, 0, 0, 0, 2, 3, 4, 6, 7, 9, 10, 12, 13, 14, 11, 7, 4, 0, 0, 0, 0, 0, 0, 0, 1, 3,
                4, 5, 7, 8, 10, 11, 13, 14, 10, 7, 3, 0, 0, 0, 0, 0, 0, 0, 2, 3, 5, 6, 7, 9, 10, 12, 13, 15, 11, 7, 4,
                0, 0, 0, 0, 0, 0, 0, 1, 3, 4, 6, 7, 8, 10, 11, 13, 14, 11, 7, 3, 0, 0, 0, 0, 0, 0, 0, 2, 3, 5, 6, 8,
                9, 10, 12, 13, 15, 11, 8, 4, 0, 0, 0, 0, 0, 0, 0, 1, 3, 4, 6, 7, 9, 10, 11, 13, 14, 11, 7, 4, 0, 0, 0,
                0, 0, 0, 0, 1, 2, 4, 5, 7, 8, 10, 11, 12, 14, 10, 7, 3, 0, 0, 0, 0, 0, 0, 0, 2, 3, 4, 6, 7, 9, 10, 12,
                13, 14 };
        testDataList.add(new VehicleQueueTestData(0.7, 0.2, 10, queueSizeValues));
    }

    private static class VehicleQueueTestData {
        private double entryDelay;
        private double exitDelay;
        private int trafficLightRate;
        private int[] queueSizeValues;

        public VehicleQueueTestData(double entryDelay, double exitDelay, int trafficLightRate, int[] queueSizeValues) {
            this.entryDelay = entryDelay;
            this.exitDelay = exitDelay;
            this.trafficLightRate = trafficLightRate;
            this.queueSizeValues = queueSizeValues;
        }

        public double getEntryDelay() {
            return entryDelay;
        }

        public double getExitDelay() {
            return exitDelay;
        }

        public int getTrafficLightRate() {
            return trafficLightRate;
        }

        public int[] getQueueSizeValues() {
            return queueSizeValues;
        }

        @Override
        public String toString() {
            return "VehicleQueueTestData[entryDelay=" + entryDelay + ", exitDelay=" + exitDelay
                    + ", trafficLightRate=" + trafficLightRate + ", queueSizeValues.length=" + queueSizeValues.length
                    + "]";
        }
    }
}
