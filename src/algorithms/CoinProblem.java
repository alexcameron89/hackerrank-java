package algorithms;

import java.util.Scanner;

/**
 * Created by 220333 on 12/8/2015.
 */
public class CoinProblem {
    public static long countPermutations(int n, int[] coins) {
        int m = coins.length;
        long[][] table = new long[n+1][m];

        for (int i = 0; i < m; i++) {
            table[0][i] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                long x;
                long y;
                if(i - coins[j] >= 0){
                    x = table[i - coins[j]][j];
                } else {
                    x = 0;
                }

                if(j > 0) {
                    y = table[i][j-1];
                } else {
                    y = 0;
                }

                table[i][j] = x + y;
            }
        }

        return table[n][m-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] coins = new int[in.nextInt()];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = in.nextInt();
        }

        System.out.println(CoinProblem.countPermutations(n, coins));
    }


}
