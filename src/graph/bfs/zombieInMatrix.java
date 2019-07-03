package graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/6/27.
 * LintCode
 * 层级bfs 就需要 size 这个变量
 * 然后对每一层的单位做bfs，查看是否满足条件
 */
public class zombieInMatrix {
    class Coordinate {
        int x, y ;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] deltaX = {1,0,0,-1};
    public int[] deltaY= {0,1,-1,0};

    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;

    public int zoobie(int[][] grid){
        if (grid == null || grid.length == 0|| grid[0].length == 0) return 0;

        int days = 0;
        int n = grid.length;
        int m = grid[0].length;

        int people = 0 ;
        Queue<Coordinate> queue = new ArrayDeque<>();
        for ( int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < m ; j++){
                if(grid[i][j] == PEOPLE){
                    people++;
                }else if (grid[i][j] == ZOMBIE){
                    queue.offer(new Coordinate(i,j));
                }
            }
        }
        if(people == 0){
            return days;
        }

        while (!queue.isEmpty()){
            days++;
            int size = queue.size();
            for (int i = 0 ; i < size ;i++){
                Coordinate zombie = queue.poll();
                for (int direction = 0 ; direction < 4 ;direction++){
                    Coordinate adj = new Coordinate(zombie.x + deltaX[direction],
                            zombie.y + deltaY[direction]);
                    if (!isPeople(adj,grid)) continue;
                    grid[adj.x][adj.y] = ZOMBIE;
                    people--;
                    if (people == 0) return days;
                    queue.offer(adj);
                }
            }
        }
        return -1;
    }

    private boolean isPeople(Coordinate adj, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (adj.x < 0 || adj.x >= n) {
            return false;
        }
        if (adj.y < 0 || adj.y >= m) {
            return false;
        }
        return (grid[adj.x][adj.y] == PEOPLE);
    }

}
