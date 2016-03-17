package algorithms;

import algorithms.AlternatingCharacters;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/9/2015.
 */
public class AlternatingCharactersTest {

    @Test
    public void findingNoCuts() throws Exception {
        assertThat(AlternatingCharacters.findCuts("ABABABAB"), equalTo(0));
    }

    @Test
    public void findingManyCuts() throws Exception {
        assertThat(AlternatingCharacters.findCuts("AAABBB"), equalTo(4));
    }
}