package aiml.maze;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 220333 on 11/27/2015.
 */
public class BFSolverTest {
    BFSolver game;

    @Before
    public void setUp() throws Exception {
        String[] boardRows = {"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%",
                              "******%*********%***%***%***%*%",
                              "%%%%%*%*%%%%%%%*%*%*%*%*%*%*%*%",
                              "%***%*%*%*******%*%***%*%*%*%*%",
                              "%*%*%*%*%*%%%%%*%*%%%%%*%%%*%*%",
                              "%*%***%*%*%***%***%***%***%***%",
                              "%*%%%%%*%*%*%*%%%%%%%*%*%*%*%%%",
                              "%*******%*%*%*%*******%*%*****%",
                              "%%%*%%%%%*%*%%%*%%%%%%%%%%%%%*%",
                              "%*%*%***%***%***%***%*****%***%",
                              "%*%*%*%%%*%%%*%%%*%*%*%%%*%*%%%",
                              "%***%*********%***%***%***%***%",
                              "%*%%%%%%%%%%%%%*%%%%%%%*%%%%%*%",
                              "%*****%***%*******%*****%*****%",
                              "%%%%%*%*%*%%%%%*%%%*%%%%%%%%%%%",
                              "%*****%*%*%***%***%***%*****%*%",
                              "%*%%%%%*%*%*%*%%%*%%%*%%%%%*%*%",
                              "%***%***%***%*******%***%*%*%*%",
                              "%%%*%*%%%%%%%%%%%*%*%*%*%*%*%*%",
                              "%***%*****%***%***%*%*%*****%*%",
                              "%*%%%%%%%%%*%*%%%*%*%%%%%%%%%*%",
                              "%*%***%***%*%*****%*%*******%*%",
                              "%*%*%*%*%*%*%*%%%%%*%*%%%%%*%*%",
                              "%***%***%***%*%***%*%*%***%*%*%",
                              "%%%%%%%%%%%%%*%%%*%*%%%*%*%*%*%",
                              "%***%*****%*******%*****%***%*%",
                              "%*%*%*%%%*%*%%%%%%%*%%%%%%%%%*%",
                              "%*%*%***%*%*******%***********%",
                              "%*%%%%%*%*%*%%%%%*%%%%%*%%%%%%%",
                              "%*******%***%*****%***********E",
                              "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"};
        Board gameBoard = new Board(boardRows.length, boardRows[0].length(), Board.buildBoardMatrix(boardRows));
        int[] start = {1, 0};
        game = new BFSolver(gameBoard,new Move("*", start, null, null));
    }

    @Test
    public void testFindShortestPath() throws Exception {
        String[] path = {"Right", "Right", "Right", "Right", "Right", "Down", "Down", "Down", "Down", "Left", "Left", "Up", "Up", "Left", "Left", "Down", "Down", "Down", "Down", "Right", "Right", "Down", "Down", "Down", "Down", "Left", "Left", "Down", "Down", "Right", "Right", "Right", "Right", "Down", "Down", "Left", "Left", "Left", "Left", "Down", "Down", "Right", "Right", "Down", "Down", "Left", "Left", "Down", "Down", "Down", "Down", "Right", "Right", "Up", "Up", "Right", "Right", "Down", "Down", "Right", "Right", "Up", "Up", "Right", "Right", "Down", "Down", "Right", "Right", "Up", "Up", "Up", "Up", "Right", "Right", "Down", "Down", "Right", "Right", "Right", "Right", "Up", "Up", "Up", "Up",  "Right", "Right", "Down", "Down", "Down", "Down", "Down", "Down", "Down", "Down", "Down", "Down", "Right", "Right", "Right", "Right", "Down", "Down", "Right", "Right", "Right", "Right", "Right", "Right", "Right"};
        List<Move> shortestPath = game.findShortestPath();
        assertArrayEquals(path, Board.getPathDirections(shortestPath));
    }
}