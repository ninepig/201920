package company.oracle.onsiteMianjing;

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

}
