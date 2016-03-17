package algorithms;

import java.util.*;

/**
 * Created by 220333 on 11/5/2015.
 */
public class FindDigits {

    public static int getDivisorsInNOfN(int n) {
        int count = 0;
        String nText = Integer.toString(n);
        int digit;

        for(int i = 0; i < nText.length(); i++) {

            digit = Character.getNumericValue(nText.charAt(i));
            if((digit != 0) && (n % digit == 0)) {
                count ++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = Integer.parseInt(input.nextLine());
        int n;
        for(int i = 0; i < tests; i++) {
            n = Integer.parseInt(input.nextLine());
            System.out.println(FindDigits.getDivisorsInNOfN(n));
        }
    }
}
