package aiml;

import aiml.BasicStatistics;
import org.junit.*;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/10/2015.
 */
public class BasicStatisticsTest {
    BasicStatistics test;

    @Before
    public void SetUpArray() throws Exception {
        int[] array = {64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060};
        test = new BasicStatistics(array);
    }

    @Test
    public void testFindStandardDeviation() throws Exception {
        assertEquals(30466.9, test.findStandardDeviation(), 0.1);
    }

    @Test
    public void testFindBounds() throws Exception {
        float[] expectedBounds = {25017.0f, 62784.2f};
        assertArrayEquals(expectedBounds, test.findBounds(), 0.1f);
    }

    @Test
    public void testFindMode() throws Exception {
        assertThat(test.findMode(), equalTo(4978));
    }

    @Test
    public void testFindMedian() throws Exception {
        assertEquals(44627.5, test.findMedian(), 0.1);
    }

    @Test
    public void testFindMean() throws Exception {
        assertEquals(43900.6, test.findMean(), 0.1);
    }
}