package algorithms;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 12/1/2015.
 */
public class FibonacciTest {

    @Test
    public void testFindFib() throws Exception {
        assertThat(Fibonacci.findFib(0, 1, 10), equalTo(new BigInteger("84266613096281243382112")));
    }
}