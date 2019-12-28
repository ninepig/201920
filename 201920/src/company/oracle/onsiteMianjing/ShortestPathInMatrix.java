package company.oracle.onsiteMianjing;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
1091. Shortest Path in Binary Matrix
算法是Leetcode 1091， 我其实并没有做得很好，我觉得最重要是交流，并不会要求Code无bug啥的。
 */
public class ShortestPathInMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        if (grid[0][0] == 1 || grid[grid.length - 1] [grid[0].length - 1] == 1) return -1;
        int[] newX = new int[]{1,1,0,-1,-1,-1,0,1};
        int[] newY = new int[]{0,-1,-1,-1,0,1,1,1};
        Queue<Node> q = new LinkedList<>();
        Node start = new Node( 0, 0 ,1);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        q.offer(start);
        while (!q.isEmpty()){
            Node cur = q.poll();
            if (cur.x == grid.length - 1 && cur.y == grid[0].length - 1  ){
                return cur.step;
            }
            for (int i = 0 ;  i < newX.length ; i++){
                int nextX = newX[i] + cur.x;
                int nextY = newY[i] + cur.y;
                if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length
                        && !visited[nextX][nextY]&& grid[nextX][nextY] == 0){
                    Node nextNode = new Node(nextX,nextY,cur.step+1);
                    visited[nextX][nextY]=true;
                    q.offer(nextNode);
                }
            }
        }
        return -1;
    }
    public  static  void  main(String ... args){
        int[][] test = new int[][]{{0,0,0,0,1},{1,0,0,0,0},{0,1,0,1,0},{0,0,0,1,1},{0,0,0,1,0}};
        System.out.println(shortestPathBinaryMatrix2(test));
    }



    private static int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

    public static int shortestPathBinaryMatrix2(int[][] grid) {

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
