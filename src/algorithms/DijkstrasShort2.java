package algorithms;

import java.util.*;

/**
 * Created by 220333 on 12/1/2015.
 */
public class DijkstrasShort2 {
    int[][] matrix;
    int[] paths;
    List<Path> pathsByLeastCost = new ArrayList<Path>();
    int start;

    public class Path {
        int toNode;
        int cost;

        public Path(int toNode, int cost) {
            this.toNode = toNode;
            this.cost = cost;
        }
    }

    public DijkstrasShort2(int[][] matrix, int start) {
        this.matrix = matrix;
        this.start = start;
        this.paths = new int[matrix.length];
    }

    public int[] findShortestPaths() {
        setInitialPathCosts();

        while (pathsByLeastCost.size() != 0) {
            Path shortestPath = pathsByLeastCost.remove(0);
            if(shortestPath.cost == 0) {
                return paths;
            }
            int currentCost = shortestPath.cost;
            paths[shortestPath.toNode] = currentCost;

            revisePaths(shortestPath.toNode, currentCost);
        }

        return paths;
    }

    private void setInitialPathCosts() {
        int[] beginningCosts = matrix[start];
        for (int i = 0; i < beginningCosts.length; i++ ) {
            if(i != start) {
                addToList(new Path(i, beginningCosts[i]));
            }
        }
    }

    private void revisePaths(int currentNode, int currentCost) {
        List<Path> temp = new ArrayList<Path>();
        Iterator<Path> it = pathsByLeastCost.iterator();

        while(it.hasNext()) {
            Path next = it.next();

            int throughCost = matrix[currentNode][next.toNode];
            if(throughCost != 0 && (next.cost == 0 || ( throughCost +currentCost< next.cost))) {
                next.cost = throughCost + currentCost;
                temp.add(next);
                it.remove();
            }
        }

        while(temp.size() > 0) {
            addToList(temp.remove(0));
        }

    }

    private void addToList(Path path) {
        boolean notAdded = true;
        int index = 0;
        while(notAdded && (index < pathsByLeastCost.size())) {
            if((path.cost != 0) && ((pathsByLeastCost.get(index).cost == 0) || (path.cost < pathsByLeastCost.get(index).cost))) {
                pathsByLeastCost.add(index, path);
                notAdded = false;
            }
            index++;

        }

        if(notAdded) {
            pathsByLeastCost.add(path);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            DijkstrasShort2 test = BuildDijkstrasShort2FromInput(in);

            int[] paths = test.findShortestPaths();
            printPath(test, paths);
            System.out.println();
        }
    }

    public static DijkstrasShort2 BuildDijkstrasShort2FromInput(Scanner in) {
        int nodes = in.nextInt();
        int edges = in.nextInt();

        int[][] matrix = buildMatrix(in, nodes, edges);

        int start = in.nextInt() - 1;
        return new DijkstrasShort2(matrix, start);
    }

    public static void printPath(DijkstrasShort2 test, int[] paths) {
        for (int j = 0; j < paths.length; j++) {
            if(j != test.start) {
                if(paths[j] == 0) {
                    System.out.print(-1);
                } else {
                    System.out.print(paths[j]);
                }

                if(j < paths.length - 1) {
                    System.out.print(" ");
                }
            }
        }
    }

    public static int[][] buildMatrix(Scanner in, int nodes, int edges) {
        int[][] matrix = new int[nodes][nodes];
        for (int j = 0; j < edges; j++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int length = in.nextInt();

            if((matrix[a][b] == 0) || (matrix[a][b] > length)) {
                matrix[a][b] = length;
                matrix[b][a] = length;
            }

        }
        return matrix;
    }
}
