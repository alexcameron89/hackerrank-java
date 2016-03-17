package algorithms;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/20/2015.
 */
public class ClosestNumbersTest {

    @Test
    public void testFind() throws Exception {
        int[] numbers = {-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854};

        assertThat(ClosestNumbers.find(numbers), equalTo("-20 30"));
    }

    @Test
    public void findingMultiplePairs() {
        int[] numbers = {5, 4, 3, 2};

        assertThat(ClosestNumbers.find(numbers), equalTo("2 3 3 4 4 5"));
    }
}