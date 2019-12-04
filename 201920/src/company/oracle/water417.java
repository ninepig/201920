package company.oracle;

import java.util.*;

public class water417 {
    class solutionBFS {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
                return res;
            int m = matrix.length ; int n = matrix[0].length;
            boolean[][] pacificHelper = new boolean[m][n];
            boolean[][] atlanticHelper = new boolean[m][n];

            Queue<int[]> pacificQueue = new LinkedList<>();
            Queue<int[]> atlanticQueue = new LinkedList<>();

            // Vertical
            for (int i = 0 ; i < m ; i++){
                pacificQueue.add(new int[] { i , 0});
                atlanticQueue.add(new int[] {i , n - 1});
                pacificHelper[i][0] = true;
                atlanticHelper[i][n - 1] = true;
            }

            // Horizantal
            for (int i = 0 ; i < n ; i++){
                pacificQueue.add(new int[] { 0 , i});
                atlanticQueue.add(new int[] {m - 1 , i});
                pacificHelper[0][i] = true;
                atlanticHelper[m - 1][i] = true;
            }

            bfs(matrix, pacificQueue , pacificHelper);
            bfs(matrix, atlanticQueue, atlanticHelper);

            for (int i = 0 ; i < m ; i ++){
                for (int j = 0 ; j < n ; j++){
                    if (pacificHelper[i][j] && atlanticHelper[i][j]){
                        res.add(Arrays.asList(i,j));
                    }
                }
            }
            return res;
        }
        private void bfs(int[][] matrix, Queue<int[]> pacificQueue, boolean[][] pacificHelper) {
            int m = matrix.length , n = matrix[0].length;
            while (!pacificQueue.isEmpty()){
                int[] curPoint = pacificQueue.poll();
                for (int[] dir : dirs){
                    int tempX = curPoint[0] + dir[0];
                    int tempY = curPoint[1] + dir[1];

                    if ( tempX < 0 || tempX >= m || tempY < 0 || tempY >= n || pacificHelper[tempX][tempY] ||
                    matrix[tempX][tempY] < matrix[curPoint[0]][curPoint[1]]){
                        continue;
                    }
                    pacificHelper[tempX][tempY] = true;
                    pacificQueue.offer(new int[]{tempX,tempY});
                }
            }
        }
    }


    public class dfsSolution {
        public List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> res = new LinkedList<>();
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return res;
            }
            int n = matrix.length, m = matrix[0].length;
            boolean[][]pacific = new boolean[n][m];
            boolean[][]atlantic = new boolean[n][m];
            for(int i=0; i<n; i++){
                dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
                dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
            }
            for(int i=0; i<m; i++){
                dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
                dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
            }
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (pacific[i][j] && atlantic[i][j])
                        res.add(new int[] {i, j});
            return res;
        }

        int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
            int n = matrix.length, m = matrix[0].length;
            if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
                return;
            visited[x][y] = true;
            for(int[]d:dir){
                dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
            }
        }
    }
}