package Array.complicated;

public class maxAreaOfisland {

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
}
