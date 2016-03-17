package algorithms;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/12/2015.
 */
public class CavityMapTest {

    @Test
    public void buildingAMap() throws Exception {
        String[] lines = {"1112", "1912", "1892", "1234"};
        int[][] expectedMap = {{1,1,1,2}, {1,9,1,2}, {1,8,9,2}, {1,2,3,4}};

        assertThat(CavityMap.buildMap(lines, 4), equalTo(expectedMap));

    }

    @Test
    public void testUpdateMap() throws Exception {
        int[][] map = {{1,1,1,2}, {1,9,1,2}, {1,8,9,2}, {1,2,3,4}};
        CavityMap test = new CavityMap(map, 4);

        String[] expectedMap = {"1112", "1X12", "18X2", "1234"};

        assertThat(test.updateMap(), equalTo(expectedMap));
    }
}