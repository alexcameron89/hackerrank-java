package algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/13/2015.
 */
public class FlowersTest {
    Flowers test;

    @Before
    public void buildTestFlowers() {
        int[] flowerPrices = {2, 5, 6};
        test = new Flowers(3, 0, flowerPrices);

    }

    @Test
    public void divvyingUpEqualFlowers() throws Exception {
        test.friends = 3;
        int[] expectedFriendPurchases = {1, 1, 1};

        test.divvyUpFlowers();

        assertThat(test.friendsByPurchaseCount, equalTo(expectedFriendPurchases));
    }

    @Test
    public void divvyingUpUnequalFlowers() throws Exception {
        test.friends = 2;
        int[] expectedFriendPurchases = {2, 1};

        test.divvyUpFlowers();

        assertThat(test.friendsByPurchaseCount, equalTo(expectedFriendPurchases));
    }

    @Test
    public void FindTotalWithAsManyFriendsAsFlowers() throws Exception {
        test.friends = 3;

        assertThat(test.findTotal(), equalTo((long)13));
    }

    @Test
    public void FindTotalWithLessFriendsThanFlowers() throws Exception {
        test.friends = 2;

        assertThat(test.findTotal(), equalTo((long)15));
    }

    @Test
    public void FindLargeTotal() {
        int[] flowerPrices = {390225, 426456, 688267, 800389, 990107, 439248, 240638, 15991, 874479, 568754, 729927, 980985, 132244, 488186, 5037, 721765, 251885, 28458, 23710, 281490, 30935, 897665, 768945, 337228, 533277, 959855, 927447, 941485, 24242, 684459, 312855, 716170, 512600, 608266, 779912, 950103, 211756, 665028, 642996, 262173, 789020, 932421, 390745, 433434, 350262, 463568, 668809, 305781, 815771, 550800};
        flowerPrices = Flowers.MergeSort.sort(flowerPrices);
        test.flowerPrices = flowerPrices;
        test.friends = 3;
        test.flowers = 50;

        assertThat(test.findTotal(), equalTo(163578911L));
    }
}