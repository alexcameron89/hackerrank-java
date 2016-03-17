package algorithms;

import algorithms.Pairs;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/4/2015.
 */
public class PairsTest {

    @Test
    public void testCountPairs() throws Exception {
        int k = 2;
        int[] array = {1, 5, 3, 4, 2};

        assertThat(Pairs.countPairs(k, array), equalTo(3));
    }

    @Test
    public void testMergeSort() {
        int[] array = {1, 5, 3, 4, 2};
        int[] expectedArray = {1, 2, 3, 4, 5};

        assertThat(Pairs.MergeSort.sort(array), equalTo(expectedArray));
    }
}