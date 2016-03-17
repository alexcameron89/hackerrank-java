package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/12/2015.
 */
public class TwoArraysTest {

    @Test
    public void PermutationIsPossible() throws Exception {
        int comparator = 10;
        String aText = "2 1 3";
        String bText = "7 8 9";

        assertTrue(TwoArrays.permutationPossible(comparator, aText, bText));

    }

    @Test
    public void PermutationIsNotPossible() throws Exception {
        int comparator = 5;
        String aText = "1 2 2 1";
        String bText = "3 3 3 4";

        assertFalse(TwoArrays.permutationPossible(comparator, aText, bText));
    }
}