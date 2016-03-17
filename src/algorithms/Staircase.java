package algorithms;

import java.util.Scanner;

/**
 * Created by 220333 on 11/4/2015.
 */
public class Staircase {
    public static void printStairCase(int n) {
        for(int i = 1; i <= n; i++ ) {
            String stair = "";
            for(int j = 0; j < n - i; j++ ) {
                stair += " ";
            }
            for (int j = 0; j < i; j++) {
                stair += "#";
            }
            System.out.println(stair);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Staircase.printStairCase(n);
    }
}
