package algorithms;

import algorithms.FindDigits;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/5/2015.
 */
public class FindDigitsTest {

    @Test
    public void findingDivisorsOfN() throws Exception {
        int n = 1012;

        assertThat(FindDigits.getDivisorsInNOfN(n), equalTo(3));
    }
}