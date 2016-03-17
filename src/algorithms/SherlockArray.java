package algorithms;

import java.util.*;

/**
 * Created by 220333 on 11/6/2015.
 */
public class SherlockArray {
    private int total;
    private int[][] array;

    public SherlockArray(String text) {
        String[] textArray = text.split(" ");
        this.array = new int[textArray.length][2];
        this.total = 0;
        for(int i = 0; i < textArray.length; i++) {
            int num = Integer.parseInt(textArray[i]);
            array[i][0] = num;
            array[i][1] = total;
            total += num;
        }
    }

    public boolean hasSameLeftRightSumInt() {
        for(int i = 0; i < array.length; i++) {
            if((total - array[i][0] - array[i][1]) == array[i][1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = Integer.parseInt(input.nextLine());
        for(int i = 0; i < tests; i++) {
            input.nextLine();
            String array = input.nextLine();
            SherlockArray sherlock = new SherlockArray(array);

            if(sherlock.hasSameLeftRightSumInt()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
