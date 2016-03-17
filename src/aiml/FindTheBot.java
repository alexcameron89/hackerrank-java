package aiml;

import java.util.*;

public class FindTheBot {
    public static int[] findCoordinates(int steps) {
        int[] coordinates = new int[2];
        int expressionSet = steps % 4;
        switch(expressionSet) {
            case 0:
                coordinates[0] = coordinates[1] = steps / -2;
                return coordinates;
            case 1:
                coordinates[0] = (int)Math.floor(steps/2) + 1;
                coordinates[1] = (int)Math.floor(steps/2) * -1;
                return coordinates;
            case 2:
                coordinates[0] = steps/2;
                coordinates[1] = coordinates[0] + 1;
                return coordinates;
            case 3:
                coordinates[0] = (steps + 1)/ -2;
                coordinates[1] = coordinates[0] * -1;
                return coordinates;
        }
        return coordinates;
    }

    public static void printCoordinates(int[] array) {
        System.out.println(array[0] + " " + array[1]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = Integer.parseInt(input.nextLine());

        for(int i = 0; i < tests; i++) {
            int steps = Integer.parseInt(input.nextLine());
            int[] coordinates = FindTheBot.findCoordinates(steps);

            printCoordinates(coordinates);
        }
    }
}