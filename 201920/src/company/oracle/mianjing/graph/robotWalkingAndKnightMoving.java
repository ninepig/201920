package company.oracle.mianjing.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class robotWalkingAndKnightMoving {
    final char BLOCKER = '2';
    final char NON_BLOCKER = '1';
    final char EXIT = '3';
    int[] xMove = new int[]{1,-1,0,0,2,-2,0,0};
    int[] yMove = new int[]{0,0,1,-1,0,0,2,-2};


    //3. 三哥。一个room，一个robot，一些blocker，一个exit，robot可以走两种step，
    // 一种叫一小步move一个unit，一种叫一大步move两个unit。问走出去的最小step。bfs可以解.
    // BFS 一定要加set 要不然会无限循环！！！
    public int minStepToExit(char[][] map){
        if (map == null || map.length == 0) return 0;
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        Node start = new Node(0 , 0 ,0);
        q.offer(start);
        visited[0][0] = true;
        while (!q.isEmpty()){
            Node cur = q.poll();
            if (map[cur.x][cur.y] == EXIT){
                return cur.step;
            }
            for (int i = 0 ; i < xMove.length ; i++){
                int newX = cur.x + xMove[i];
                int newY = cur.y + yMove[i];
                int newStep = cur.step + 1;
                if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length || map[newX][newY] == BLOCKER
                ||visited[newX][newY] == true){
                    continue;
                }else {
                    Node current = new Node(newX, newY , newStep);
                    q.offer(current);
                    visited[newX][newY] = true;
                }
            }
        }
        // No way to get out.
        return -1;
    }
    class Node{
        int x ;
        int y;
        int step;
        Node(int x, int y, int step){
            this.x = x;
            this.y = y;
        }
        Node(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    // 马走格子
    public boolean knightGetEnd(int[][] map , int startX, int startY,int endX,  int endY){
        if (map == null || map.length == 0) return false;
        int[] newX = new int[]{1,-1,2,-2,1,-1,2,-2};
        int[] newY = new int[]{2,2,1,1,-2,-2,-1,-1};
        Queue<Node> q = new LinkedList<>();
        Node start = new Node(startX, startY);
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[0][0] = true;
        q.offer(start);
        while (!q.isEmpty()){
            Node cur = q.poll();
            if (cur.x == endX && cur.y == endY ){
                return true;
            }
            for (int i = 0 ; i< newX.length ; i++){
                int nextX = cur.x + newX[i];
                int nextY = cur.y + newY[i];
                if (nextX >= 0 && nextX < map.length && nextY >=0 && nextY < map[0].length && !visited[nextX][nextY] == true){
                    Node next = new Node(nextX,nextY);
                    q.offer(next);
                }
            }
        }
        return false;
    }

    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public List<Integer> monkeyPath(int[][] matrix){
        if (matrix == null || matrix.length == 0) return null;
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfs(res, 0 , 0,matrix,visited , new ArrayList<Integer>());
        return res;
    }

    // 直接dfs的话 就不需要 backtrack。
    private void dfs(List<Integer> res, int x, int y, int[][] matrix, boolean[][] visited, ArrayList<Integer> path) {
        if (x == matrix.length - 1  && y == matrix[0].length - 1 ){
            path.add(matrix[x][y]);
            for (int i = 0 ; i < path.size() ; i++){
                res.add(path.get(i));
            }
            return;
        }else {
            visited[x][y] = true;
            path.add(matrix[x][y]);
            for (int[] dir : dirs){
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (nextX >= 0 && nextX < matrix.length && nextY >=0 && nextY < matrix[0].length &&
                        (matrix[nextX][nextY] == matrix[x][y] ||matrix[nextX][nextY] == matrix[x][y] + 1 ||
                matrix[nextX][nextY] == matrix[x][y] - 1) && !visited[nextX][nextY]){
                    dfs(res,nextX,nextX,matrix,visited,path);
                }
            }
        }
    }
}
