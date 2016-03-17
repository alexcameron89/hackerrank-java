package algorithms;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 12/8/2015.
 */
public class CoinProblemTest {

    @Test
    public void testCountPermutations() throws Exception {
        int[] array = {1, 2, 3};
        int n = 4;

        assertThat(CoinProblem.countPermutations(n, array), equalTo(4L));
    }

    @Test
    public void testTwoCountPermutations() throws Exception {
        int[] array = {2, 5, 3, 6};
        int n = 10;

        assertThat(CoinProblem.countPermutations(n, array), equalTo(5L));
    }
}