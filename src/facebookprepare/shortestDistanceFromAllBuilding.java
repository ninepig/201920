package facebookprepare;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/6/30.
 */
public class shortestDistanceFromAllBuilding {
    /**
     * @param grid: the 2D grid
     * @return: the shortest distance
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        int n = grid.length;
        int m = grid[0].length;
        int [][] reach = new int[n][m];
        int [][] distance = new int[n][m];
        int building = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1){
                    building++;
                    boolean[][] visited = new boolean[n][m];
                    Queue<node> q = new ArrayDeque<>();
                    q.offer(new node(i,j));
                    int dist = 0;
                    while(!q.isEmpty()){
                        int size = q.size();
                        for(int k = 0;k < size;k++){
                            node curr = q.poll();
                            int x = curr.x;
                            int y = curr.y;
                            distance[x][y] += dist;
                            reach[x][y]++;
                            if(x > 0 && grid[x - 1][y] == 0 && !visited[x - 1][y]){
                                q.offer(new node(x - 1,y));
                                visited[x - 1][y] = true;
                            }
                            if(x + 1 < n && grid[x + 1][y] == 0 && !visited[x + 1][y]){
                                q.offer(new node(x + 1,y));
                                visited[x + 1][y] = true;
                            }
                            if(y > 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]){
                                q.offer(new node(x,y - 1));
                                visited[x][y - 1] = true;
                            }
                            if(y + 1 < m && grid[x][y + 1] == 0 && !visited[x][y + 1]){
                                q.offer(new node(x,y + 1));
                                visited[x][y + 1] = true;
                            }
                        }
                        dist++;
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i  < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 0 && distance[i][j] < res && reach[i][j] == building){
                    res = distance[i][j];
                }
            }
        }
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return res;
        }
    }
    class node {
        int x, y;
        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestDistance2(int[][] grid) {
        // Write your code here
        //corner case
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int[][] cost = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    bfs(grid, cost, i, j, rows, cols, directions);
                }
            }
        }

        int minDis = Integer.MAX_VALUE;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0 && cost[i][j] != 0){
                    minDis = Math.min(cost[i][j], minDis);
                }
            }
        }
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    private void bfs(int[][] grid, int[][] cost, int i, int j, int rows, int cols, int[][] directions){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        boolean[][] visited = new boolean[rows][cols];
        visited[i][j] = true;
        int distance = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] cur = queue.poll();
                for(int[] dir : directions){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];

                    if(x >= 0 && x < rows && y >= 0 && y < cols && visited[x][y] == false && grid[x][y] == 0){
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                        cost[x][y] += distance;
                    }
                }
            }
            distance ++;
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 0 && visited[r][c] == false){
                    grid[r][c] = 2;
                }
            }
        }
    }
}
