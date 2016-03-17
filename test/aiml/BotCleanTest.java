package aiml;

import aiml.BotClean;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/10/2015.
 */
public class BotCleanTest {

    @Test
    public void testFindClosestDirtBelow() throws Exception {
        String[] board = { "b---d",
                           "-d--d",
                           "--dd-",
                           "--d--",
                           "----d" };

        BotClean testBot = new BotClean(0,0,board);
        int[] expectedCoordinates = {1,1};

        assertThat(testBot.findClosestDirt(), equalTo(expectedCoordinates));
    }

    @Test
    public void testFindClosestDirtAbove() throws Exception {
        String[] board = {  "-d--d",
                            "-b--d",
                            "--dd-",
                            "--d--",
                            "----d" };

        BotClean testBot = new BotClean(1,1,board);
        int[] expectedCoordinates = {0,1};

        assertThat(testBot.findClosestDirt(), equalTo(expectedCoordinates));
    }

    @Test
    public void testFindClosestDirtRight() throws Exception {
        String[] board = {  "----d",
                            "-bd-d",
                            "--dd-",
                            "--d--",
                            "----d" };

        BotClean testBot = new BotClean(1,1,board);
        int[] expectedCoordinates = {1,2};

        assertThat(testBot.findClosestDirt(), equalTo(expectedCoordinates));
    }

    @Test
    public void testFindClosestDirtLeft() throws Exception {
        String[] board = {  "----d",
                            "db--d",
                            "--dd-",
                            "--d--",
                            "----d" };

        BotClean testBot = new BotClean(1,1,board);
        int[] expectedCoordinates = {1,0};

        assertThat(testBot.findClosestDirt(), equalTo(expectedCoordinates));
    }

    @Test
    public void testFindDirtInSamePosition() {
        String[] board = {  "-d---",
                            "-----",
                            "---d-",
                            "---d-",
                            "--d-d" };
        BotClean testBot = new BotClean(0,1,board);
        int[] expectedCoordinates = {0,1};

        assertThat(testBot.findClosestDirt(), equalTo(expectedCoordinates));
    }
}