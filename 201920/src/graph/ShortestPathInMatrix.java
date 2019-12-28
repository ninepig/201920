package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
经历了1091 还有 机器人题
所有bfs 走迷宫 不能用 hashset 设置node
而是应该用boolean 数组来做！
切记
 */
public class ShortestPathInMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        if (grid[0][0] == 1 || grid[grid.length - 1] [grid[0].length - 1] == 1) return -1;
        int[] newX = new int[]{1,1,0,-1,-1,-1,0,1};
        int[] newY = new int[]{0,-1,-1,-1,0,1,1,1};
        Queue<Node> q = new LinkedList<>();
        Node start = new Node( 0, 0 ,1);
        HashSet<Node> visited = new HashSet<>();
        visited.add(start);
        q.offer(start);
        while (!q.isEmpty()){
            Node cur = q.poll();
            if (cur.x == grid.length - 1 && cur.y == grid[0].length - 1  ){
                return cur.step;
            }
            for (int i = 0 ;  i < newX.length ; i++){
                int nextX = newX[i] + cur.x;
                int nextY = newY[i] + cur.y;
                Node nextNode = new Node(nextX,nextY,cur.step+1);
                if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length
                        && !visited.contains(nextNode) && grid[nextX][nextY] == 0){
                 q.offer(nextNode);
                }
            }
        }
        return -1;
    }
    public  static  void  main(String ... args){
        // test hashset
        Node a = new Node(0,0,0);
        Node b = new Node(0,0,0);
        HashSet<Node> test = new HashSet<>();
        System.out.println(test.add(a));
        System.out.println(test.add(b));
    }



    private int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

    public int shortestPathBinaryMatrixWithoutSet(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]==1 || grid[m-1][n-1]==1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int ans=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] pop = queue.remove();
                if(pop[0]==m-1 && pop[1]==n-1) {
                    return ans+1;
                }
                for (int k=0;k<8;k++) {
                    int nextX = dir[k][0]+pop[0];
                    int nextY = dir[k][1]+pop[1];

                    if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && !visited[nextX][nextY] && grid[nextX][nextY]==0) {
                        queue.add(new int[]{nextX,nextY});
                        visited[nextX][nextY]=true;
                    }

                }
            }
            ans++;
        }

        return -1;
    }
}

class Node{
    int x;
    int y;
    int step;
    public Node(int x, int y , int step){
        this.x = x;
        this.y = y;
        this.step = step;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", step=" + step +
                '}';
    }





}
