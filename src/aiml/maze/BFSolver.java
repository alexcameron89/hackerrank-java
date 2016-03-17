package aiml.maze;

import java.util.*;

/**
 * Created by 220333 on 11/27/2015.
 */
public class BFSolver {
    Board gameBoard;
    Move start;
    List<Move> visited = new ArrayList<Move>();
    List<Move> frontier = new ArrayList<Move>();;

    public BFSolver(Board gameBoard, Move start) {
        this.gameBoard = gameBoard;
        this.start = start;
    }

    public List<Move> findShortestPath() {
        frontier.add(start);
        while(frontier.size() != 0) {
            Move currentMove = frontier.remove(0);
            visited.add(currentMove);
            if(currentMove.isExit()) {
                return buildPath(currentMove);
            }
            List<Move> movesFromCurrent = gameBoard.explore(currentMove);
            frontier.addAll(filterExplored(movesFromCurrent));
        }

        return null;
    }

    private List<Move> buildPath(Move currentMove) {
        List<Move> shortestPath = new ArrayList<Move>();
        while(notStartPosition(currentMove)) {
            shortestPath.add(0, currentMove);
            currentMove = currentMove.cameFrom;
        }

        return shortestPath;
    }

    private boolean notStartPosition(Move currentMove) {
        return !Arrays.equals(currentMove.position, start.position);
    }

    private List<Move> filterExplored(List<Move> movesFromCurrent) {
        Iterator<Move> movesIterator = movesFromCurrent.iterator();
        while(movesIterator.hasNext()) {
            Move possibleMove = movesIterator.next();
            for(Move frontierMove: frontier) {
                if(Arrays.equals(frontierMove.position, possibleMove.position)) {
                    movesIterator.remove();
                }
            }

            for(Move alreadyVisited: visited) {
                if(Arrays.equals(alreadyVisited.position, possibleMove.position)) {
                    movesIterator.remove();
                }
            }
        }
        return movesFromCurrent;
    }
}
