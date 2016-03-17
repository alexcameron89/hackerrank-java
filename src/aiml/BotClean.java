package aiml;

import java.util.*;


public class BotClean {
    final private int posr;
    final private int posc;
    final private String[] board;

    public BotClean(int posr, int posc, String[] board) {
        this.posr = posr;
        this.posc = posc;
        this.board = board;
    }

    public int[] checkRow(int distance, String row, int[] closest) {
        if(row.matches(".*d.*")) {
            int closestDistance = Math.abs(closest[0] - posr) + Math.abs(closest[1] - posc);
            int rowNum = posr + distance;
            for(int i = 0; i < row.length(); i++) {
                if(row.charAt(i) == 'd') {
                    int newDistance = Math.abs(rowNum - posr) + Math.abs(i - posc);
                    if(newDistance < closestDistance) {
                        closest[0] = rowNum;
                        closest[1] = i;
                    }
                }
            }
        }
        return closest;
    }

    public int[] findClosestDirt() {
        int distance = 0;
        int[] closest = {100, 100};

        while((distance < closest[0] + closest[1]) && ((distance  + posr < board.length) || (posr - distance >= 0))) {
            if(distance  + posr < board.length) {
                String belowRow = board[posr + distance];
                closest = checkRow(distance, belowRow, closest);
            }
            if(posr - distance >= 0) {
                String aboveRow = board[posr - distance];
                closest = checkRow(-1 *distance, aboveRow, closest);
            }

            distance++;
        }
        return closest;
    }

    public String chooseDirection(int[] dirtCoordinates) {
        int rDistance = Math.abs(posr - dirtCoordinates[0]);
        int cDistance = Math.abs(posc - dirtCoordinates[1]);
        if((rDistance == 0) && (cDistance == 0)) {
            return "CLEAN";
        } else if (rDistance >= cDistance) {
            if((posr - dirtCoordinates[0]) > 0) {
                return "UP";
            } else {
                return "DOWN";
            }
        } else {
            if((posc - dirtCoordinates[1]) > 0) {
                return "LEFT";
            } else {
                return "RIGHT";
            }
        }
    }

    static void next_move(int posr, int posc, String[] board){
        BotClean bot = new BotClean(posr, posc, board);
        int[] dirt = bot.findClosestDirt();
        System.out.println(bot.chooseDirection(dirt));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}