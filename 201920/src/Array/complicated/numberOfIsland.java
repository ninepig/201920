package Array.complicated;

public class numberOfIsland {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == '1'){
                    helper(grid, i , j , visited);
                    count++;
                }
            }
        }
        return  count;
    }

    private void helper(char[][] grid, int i, int j, boolean[][] visited) {
        if (grid[i][j] != '1' || i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        helper(grid,i+1,j,visited);
        helper(grid, i -1 ,j , visited);
        helper(grid, i , j+1 , visited);
        helper(grid,i, j-1, visited);
    }


    public int numIslandsWithOutHelper(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i,j+1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }

}
