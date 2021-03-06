package company.oracle.mianjing.dfs;

import company.oracle.mianjing.StringRelated.braceReplaceAndislandNumberThreeWays;

public class islandSerial {
    public int numIslands(char[][] island) {
        if (island == null || island.length ==0) return 0;
        int count = 0;
        for (int i = 0 ; i < island.length ; i++){
            for (int j = 0 ; j < island[0].length ; j++){
                if (island[i][j] == '1'){
                    dfs(island, i , j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] island, int row, int column) {
        // 要放到最后判断， 要不然会越界！
        if ( row >= island.length || row < 0 || column >=island[0].length
                || column < 0 || island[row][column] == '0' ) return;
        island[row][column] = '0';
        dfs(island, row + 1 , column);
        dfs(island, row - 1 , column);
        dfs(island, row , column + 1);
        dfs(island, row, column - 1);
    }


    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int result = 0;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j  < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i , j , 0);
                    result = Math.max(area, result);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j, int area) {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 ){
            return area;
        }
        area++;
        grid[i][j] = 0;
        area = dfs(grid,i +1 , j , area);
        area = dfs(grid , i - 1 , j , area);
        area = dfs(grid , i , j + 1 ,area);
        area = dfs(grid , i , j - 1 , area);
        return area;
    }


    public static int sizeOfDifferentIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int result = 0;
        boolean[][] helper = new boolean[grid.length][grid[0].length];
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j  < grid[0].length ; j++){
                if(grid[i][j] != 0 && !helper[i][j]){
                    dfs(grid, i , j , grid[i][j], helper);
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] grid, int i, int j, int previousColor, boolean[][] helper) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || previousColor!= grid[i][j] || helper[i][j])
            return;
        helper[i][j] = true;
        dfs(grid,i+1,j,previousColor,helper);
        dfs(grid,i,j+1,previousColor,helper);
        dfs(grid,i-1,j,previousColor,helper);
        dfs(grid,i,j-1,previousColor,helper);
    }


    public static  void main(String ... args){
        int[][] island = new int[][]{{1,1,1},{2,2,2},{3,3,3}};
        System.out.println(sizeOfDifferentIsland(island));
    }




        int[][] distance = { { 1, 0 }, {-1, 0 }, { 0, 1 }, { 0, -1 } };
        public int numIslandsUF(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            UnionFind uf = new UnionFind(grid);
            int rows = grid.length;
            int cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        for (int[] d: distance) {
                            int x = i + d[0];
                            int y = j + d[1];
                            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                                int id1 = i * cols + j;
                                int id2 = x * cols + y;
                                uf.union(id1, id2);
                            }
                        }
                    }
                }
            }
            return uf.count;
        }

        class UnionFind {
            int[] father;
            int m, n;
            int count = 0;
            UnionFind(char[][] grid) {
                m = grid.length;
                n = grid[0].length;
                father = new int[m * n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == '1') {
                            int id = i * n + j;
                            father[id] = id;
                            count++;
                        }
                    }
                }
            }
            public void union(int node1, int node2) {
                int find1 = find(node1);
                int find2 = find(node2);
                if (find1 != find2) {
                    father[find1] = find2;
                    count--;
                }
            }
            public int find(int node) {
                if (father[node] == node) {
                    return node;
                }
                father[node] = find(father[node]);
                return father[node];
            }
        }

}
