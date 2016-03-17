package algorithms;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 12/3/2015.
 */
public class XORNinjaTest {

    @Test
    public void testXORPowerSets() throws Exception {
        File inputFile = new File(DijkstrasShort2Test.class.getResource("XORNinjaTest").getFile());
        assertThat(XORNinja.XORPowerSets(new Scanner(inputFile)), equalTo(1648L));
    }
}