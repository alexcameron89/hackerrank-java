package algorithms;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 220333 on 12/2/2015.
 */
public class XORNinja {

    public static long XORPowerSets(Scanner in) {
        int count = in.nextInt();
        long max = 0;
        long or = 0;
        long[] numbers = new long[count];
        for(int i = 0; i < count; i++) {
            or = (or | in.nextInt()) % 1000000007;
        }

        return or * (long)Math.pow(2,count - 1) % 1000000007;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            System.out.println(XORPowerSets(in));
        }

    }

}
