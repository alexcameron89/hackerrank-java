package algorithms;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by 220333 on 12/23/2015.
 */
public class Cluedo {
    public static void main(String[] args) {
        String[] people = {"Green", "Mustard", "Peacock", "Plum", "White"};
        String[] rooms = {"Living Room", "Billiards Room", "Dining Room", "Library", "Observatory"};
        String[] weapons = {"Knife", "Wrench", "Pipe", "Candlestick", "Rope"};

        while(true) {
            Scanner input = new Scanner(System.in);
            Random number = new Random();
            input.nextLine();
            System.out.print(people[number.nextInt(5)] + ", " + rooms[number.nextInt(5)] + ", " + weapons[number.nextInt(5)]);

        }
    }
}
