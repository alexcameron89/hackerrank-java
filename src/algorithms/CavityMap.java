package algorithms;

import java.util.Scanner;

/**
 * Created by 220333 on 11/12/2015.
 */
public class CavityMap {
    int size;
    int[][] map;

    public CavityMap(int[][] map, int size) {
        this.map = map;
        this.size = size;
    }

    public CavityMap(String[] lines, int size) {
        this.size = size;
        this.map = CavityMap.buildMap(lines, size);
    }

    public String[] updateMap() {
        String[] mapString = new String[size];

        mapString[0] = arrayToString(map[0]);

        for(int i = 1; i < size - 1; i++) {
            String mapLine = "";
            int[] array = map[i];
            mapLine += array[0];

            for(int j = 1; j < size - 1; j++) {
                if(isCavity(i, j)) {
                    mapLine += "X";
                } else {
                    mapLine += map[i][j];
                }
            }

            mapLine += array[size - 1];
            mapString[i] = mapLine;
        }

        mapString[size - 1] = arrayToString(map[size - 1]);
        return mapString;
    }

    private boolean isCavity(int i, int j) {
        if((map[i][j] > map[i+1][j])
                && (map[i][j] > map[i-1][j])
                && (map[i][j] > map[i][j+1])
                && (map[i][j] > map[i][j-1])) {
            return true;
        }

        return false;
    }

    public String arrayToString(int[] array){
        String result = "";
        for(int i = 0; i < array.length; i++) {
            result += array[i];
        }

        return result;
    }

    public static void printMap(String[] map) {
        for(int i = 0; i < map.length; i++) {
            System.out.println(map[i]);
        }
    }

    public static int[][] buildMap(String[] lines, int size) {
        int[][] map = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(lines[i].charAt(j)));
            }
        }

        return map;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        String[] lines = new String[size];

        for(int i = 0; i < size; i++) {
            lines[i] = in.nextLine();
        }

        CavityMap map = new CavityMap(lines, size);
        CavityMap.printMap(map.updateMap());
    }
}
