package aiml.maze;

import java.util.List;

/**
 * Created by 220333 on 11/27/2015.
 */
public class Move {
    String symbol;
    String direction;
    int[] position;
    Move cameFrom;

    public Move(String symbol, int[] position, Move cameFrom, String direction) {
        this.symbol = symbol;
        this.position = position;
        this.cameFrom = cameFrom;
        this.direction = direction;
    }

    public Move(int[] position) {
        this.position = position;
    }

    public boolean isExit() {
        return symbol.equals("E");
    }
}
