package algorithms;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 12/1/2015.
 */
public class DijkstrasShort2Test {
    DijkstrasShort2 test;

    @Before
    public void largeTest() throws FileNotFoundException {
        File inputFile = new File(DijkstrasShort2Test.class.getResource("DijkstrasTest1").getFile());
        test = DijkstrasShort2.BuildDijkstrasShort2FromInput(new Scanner(inputFile));
    }

    @Test
    public void testFindShortestPaths() throws Exception {
        int[][] matrix = {{0,24,3,20},{24,0,0,0},{3,0,0,12},{20,0,12,0}};
        DijkstrasShort2 test = new DijkstrasShort2(matrix, 0);

        int[] expectedArray = {0, 24, 3, 15};
        assertThat(test.findShortestPaths(), equalTo(expectedArray));
    }

    @Test
    public void passingLargeTest() {
        int[] expectedArray = {154,90,186,190,178,114,123,0,0,123,0,104,0,0,0,207,134,123,98,155,0,198,68,90,170,135,0,103,145,0,54,111,163,173,115,87,159,75,0,94,102,0,76,67,167,138,216,0,172,102,212,163,103,112,0,182,49,145,92,0,0,194,0,182,0,201,96,0,85,121,108,161,130,100,120,0,0,118,215,92,156,162,163,168,0,71,110,0,0,190,217,100,105,178};
        assertThat(test.findShortestPaths(), equalTo(expectedArray));
    }

    @Test
    public void matrixIsMirrored() {
        for (int i = 0; i < test.matrix.length; i++) {
            for (int j = i; j < test.matrix.length; j++) {
                assertThat(test.matrix[i][j], equalTo(test.matrix[j][i]));
            }
        }
    }


}