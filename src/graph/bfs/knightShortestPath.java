package graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/6/27.
 * 又是一道层级bfs， 必须走size，然后一般setp++ 类似word ladder
 */
public class knightShortestPath {
    class Point {
       int x, y;
       Point() { x = 0; y = 0; }
       Point(int a, int b) { x = a; y = b; }
  }
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(source);

        int[] directionX = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
        int[] directionY = new int[] {2, -2, 2, -2, 1, -1, 1, -1};
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point pt = queue.poll();
                if (pt.x == destination.x && pt.y == destination.y) {
                    return step;
                }
                for (int j = 0; j < 8; j++) {
                    Point next = new Point(pt.x + directionX[j], pt.y + directionY[j]);
                    if (inBound(grid, next) && !grid[next.x][next.y]) {
                        queue.offer(next);
                        grid[next.x][next.y] = true;
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public boolean inBound(boolean[][] grid, Point pt) {
        return pt.x >= 0 && pt.x < grid.length && pt.y >= 0 && pt.y < grid[0].length;
    }
}
