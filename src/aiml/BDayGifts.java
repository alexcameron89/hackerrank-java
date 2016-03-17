package aiml;

import java.util.Scanner;

/**
 * Created by 220333 on 11/11/2015.
 */
public class BDayGifts {
    long bCount;
    long wCount;
    long bCost;
    long wCost;
    long zCost;

    public BDayGifts(long bCount, long wCount, long bCost, long wCost, long zCost) {
        this.bCount = bCount;
        this.wCount = wCount;
        this.bCost = bCost;
        this.wCost = wCost;
        this.zCost = zCost;
    }

    public long findTotal() {
        if(bCost + zCost < wCost) {
            return (bCost + zCost) * wCount + bCost * bCount;
        } else if (wCost + zCost < bCost) {
            return (wCost + zCost) * bCount + wCost * wCount;
        } else {
            return bCost * bCount + wCost * wCount;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long tests = Long.parseLong(input.nextLine());

        for(long i = 0; i < tests; i++) {
            String[] bw = input.nextLine().split(" ");
            long b = Long.parseLong(bw[0]);
            long w = Long.parseLong(bw[1]);

            String[] xyz = input.nextLine().split(" ");
            long x = Long.parseLong(xyz[0]);
            long y = Long.parseLong(xyz[1]);
            long z = Long.parseLong(xyz[2]);

            BDayGifts test = new BDayGifts(b, w, x, y, z);
            System.out.println(test.findTotal());
        }
    }
}
