package algorithms;

import java.util.Scanner;

/**
 * Created by 220333 on 11/9/2015.
 */
public class AlternatingCharacters {
    public static int findCuts(String string) {
        int count = 0;
        String letter = String.valueOf(string.charAt(0));

        for(int i = 1; i < string.length(); i++) {
            if(letter.compareTo(String.valueOf(string.charAt(i))) == 0) {
                count += 1;
            }

            letter = String.valueOf(string.charAt(i));
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = Integer.parseInt(input.nextLine());

        for(int i = 0; i < tests; i++) {
            String string = input.nextLine();
            System.out.println(AlternatingCharacters.findCuts(string));
        }
    }
}
