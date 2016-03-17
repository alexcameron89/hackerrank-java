package algorithms;

import java.util.Scanner;

/**
 * Created by 220333 on 11/23/2015.
 */
public class Darts {
    long[] circles;
    long[][] shots;

    public Darts(long[] circles, long[][] shots) {
        this.circles = circles;
        this.shots = shots;
    }


    public static long calculateScore(long[] circles, long[][] shots) {
        long score = 0;
        for(int i = 0; i < shots.length; i++) {
            score += Darts.calculateShot(circles, shots[i]);
        }

        return score;
    }

    private static long calculateShot(long[] circles, long[] shot) {
        long aSquared = shot[0] * shot[0];
        long bSquared = shot[1] * shot[1];
        long radius = aSquared + bSquared;
        for(int i = circles.length - 1; i >= 0; i-- ) {
            if(radius <= (circles[i])) {
                return i + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] kN = in.nextLine().split(" ");
        int k = Integer.parseInt(kN[0]);
        int n = Integer.parseInt(kN[1]);
        String[] cString = in.nextLine().split(" ");

        long[] circles = new long[k];
        for(int i = 0; i < k; i++) {
            long num = Long.parseLong(cString[i]);
            circles[i] = num * num;
        }

        long[][] darts = new long[n][2];
        for(int i = 0; i < n; i++) {
            String[] lineSplit = in.nextLine().split(" ");
            darts[i][0] = Integer.parseInt(lineSplit[0]);
            darts[i][1] = Integer.parseInt(lineSplit[1]);
        }

        System.out.println(Darts.calculateScore(circles, darts));
    }
}
