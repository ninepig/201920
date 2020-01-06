package subcategory.graphbfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/7/4.
 */
public class ShortestDistanceFromAllBuilding {
    final private int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        // Record final distance from each node
        int[][] cost = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, cost, i, j, row, col);
                }
            }
        }
        int minDist = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && cost[i][j] != 0) {
                    minDist = Math.min(cost[i][j], minDist);
                }
            }
        }
        return minDist;
    }

    private void bfs(int[][] grid, int[][] cost, int i, int j, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        boolean[][] visited = new boolean[row][col];
        visited[i][j] = true;
        int distance = 1;

        while (!queue.isEmpty()){
            // 层序bfs
            int size = queue.size();
            for (int k = 0 ; k < size ; k++){
                int[] curr = queue.poll();
                for (int[] singleD : direction){
                    int x = curr[0] + singleD[0];
                    int y = curr[1] + singleD[1];
                    if (x >= 0 && x < row && y>= 0 && y < col &&!visited[x][y] && grid[x][y] == 0 ){
                        queue.offer(new int[]{x,y});
                        visited[x][y] = true;
                        cost[x][y] += distance;
                    }
                }
            }
            distance++;
        }
        // improving by set node never be visited to obstacal. So we can skip that next time
        for (int r = 0 ; r < row; r++){
            for (int p = 0 ; p < col ;p++){
                if (grid[r][p] == 0 && visited[r][p] == false){
                    grid[r][p] = 2;
                }
            }
        }
    }

}