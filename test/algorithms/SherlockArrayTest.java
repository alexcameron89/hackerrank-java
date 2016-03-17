package algorithms;

import algorithms.SherlockArray;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/6/2015.
 */
public class SherlockArrayTest {

    @Test
    public void ArrayHasSameLeftRightSumIntReturnsFalse() throws Exception {
        String array = "1 2 3";
        SherlockArray test = new SherlockArray(array);

        assertFalse(test.hasSameLeftRightSumInt());
    }

    @Test
    public void ArrayHasSameLeftRightSumIntReturnsTrue() throws Exception {
        String array = "1 2 3 3";
        SherlockArray test = new SherlockArray(array);

        assertTrue(test.hasSameLeftRightSumInt());
    }
}