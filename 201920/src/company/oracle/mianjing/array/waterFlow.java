package company.oracle.mianjing.array;

import java.util.*;

public class waterFlow {
    int[] dirX = new int[]{1,-1,0,0};
    int[] dirY = new int[]{0,0,1,-1};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length ==0) return res;
        int m = matrix.length , n = matrix[0].length;
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        // Inital Vertial
        for (int i = 0 ; i < m ; i++){
            pVisited[i][0] = true;
            aVisited[i][n-1] = true;
            aQueue.offer(new int[]{i,n-1});
            pQueue.offer(new int[]{i, 0});
        }
        // Inital horizontal
        for (int i = 0 ; i < n ; i++){
            pVisited[0][i] = true;
            aVisited[m-1][i] = true;
            aQueue.offer(new int[]{m-1,i});
            pQueue.offer(new int[]{0, i});
        }

        bfs(pQueue, pVisited , matrix);
        bfs(aQueue,aVisited,matrix);

        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (aVisited[i][j] && pVisited[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> pQueue, boolean[][] pVisited, int[][] matrix) {
        while (!pQueue.isEmpty()){
            int[] temp = pQueue.poll();
            for(int i = 0 ; i < dirX.length ; i++){
                int newX = temp[0] + dirX[0];
                int newY = temp[1] + dirX[1];
                if (!pVisited[newX][newY] && newX >= 0 && newY >= 0&& newX < matrix.length && newY < matrix[0].length
                && matrix[newX][newY] < matrix[temp[0]][temp[1]]){
                    pVisited[newX][newY] = true;
                    pQueue.offer(new int[]{newX , newY});
                }
            }
        }
    }
}