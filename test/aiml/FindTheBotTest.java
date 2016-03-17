package aiml;

import aiml.FindTheBot;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/9/2015.
 */
public class FindTheBotTest {

    @Test
    public void TakingOneStep() throws Exception {
        int[] expectedCoordinates = {1, 0};

        assertThat(FindTheBot.findCoordinates(1), equalTo(expectedCoordinates));
    }

    @Test
    public void TakingSixSteps() {
        int[] expectedCoordinates = {3, 4};

        assertThat(FindTheBot.findCoordinates(6), equalTo(expectedCoordinates));
    }

    @Test
    public void TakingElevenSteps() {
        int[] expectedCoordinates = {-6, 6};

        assertThat(FindTheBot.findCoordinates(11), equalTo(expectedCoordinates));
    }

    @Test
    public void TakingEightSteps() {
        int[] expectedCoordinates = {-4, -4};

        assertThat(FindTheBot.findCoordinates(8), equalTo(expectedCoordinates));
    }
}