package aiml.maze;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 220333 on 11/27/2015.
 */
public class Board {
    int height;
    int width;
    String[][] matrix;

    public Board(int height, int width, String[][] matrix) {
        this.height = height;
        this.width = width;
        this.matrix = matrix;
    }

    public static String[][] buildBoardMatrix(String[] boardRows) {
        String[][] board = new String[boardRows.length][boardRows[0].length()];
        for (int i = 0; i < boardRows.length; i++) {
            for (int j = 0; j < boardRows[i].length(); j++) {
                board[i][j] = String.valueOf(boardRows[i].charAt(j));
            }
        }

        return board;
    }

    public List<Move> explore(Move currentMove) {
        int currentRow = currentMove.position[0];
        int currentColumn = currentMove.position[1];
        List<Move> newMoves = new ArrayList<Move>();

//        Prioritizes clockwise starting from the Right
        if(rightIsClear(currentRow, currentColumn)) {
            newMoves.add(newMove(currentMove, currentRow, currentColumn + 1, "Right"));
        }
        if(downIsClear(currentRow, currentColumn)) {
            newMoves.add(newMove(currentMove, currentRow + 1, currentColumn, "Down"));
        }
        if(leftIsClear(currentRow, currentColumn)) {
            newMoves.add(newMove(currentMove, currentRow, currentColumn - 1, "Left"));
        }
        if(upIsClear(currentRow, currentColumn)) {
            newMoves.add(newMove(currentMove, currentRow - 1, currentColumn, "Up"));
        }

        return newMoves;
    }

    private boolean rightIsClear(int currentRow, int currentColumn) {
        return (currentColumn < width && !matrix[currentRow][currentColumn + 1].equals("%"));
    }

    private boolean downIsClear(int currentRow, int currentColumn) {
        return (currentRow < height && !matrix[currentRow + 1][currentColumn].equals("%"));
    }

    private boolean leftIsClear(int currentRow, int currentColumn) {
        return (currentColumn > 0 && !matrix[currentRow][currentColumn - 1].equals("%"));
    }

    private boolean upIsClear(int currentRow, int currentColumn) {
        return (currentRow > 0 && !matrix[currentRow - 1][currentColumn].equals("%"));
    }

    private Move newMove(Move currentMove, int newRow, int newColumn, String direction) {
        int[] location = {newRow, newColumn};
        return new Move(matrix[newRow][newColumn], location, currentMove, direction);
    }

    public static String[] getPathDirections(List<Move> shortestPath) {
        String[] directions = new String[shortestPath.size()];

        for (int i = 0; i < shortestPath.size(); i++) {
            directions[i] = shortestPath.get(i).direction;
        }

        return directions;
    }
}
