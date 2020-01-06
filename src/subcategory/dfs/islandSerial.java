package subcategory.dfs;

/**
 * Created by yangw on 2019/7/6.
 */
public class islandSerial {
    //dfs ,set the adjacant 1 to 0 then count!
    // Most normal version
    public int numIslands(char[][] grid) {
        if (grid==null||grid.length==0){
            return 0;
        }
        int count = 0;
        for(int i =  0; i<grid.length;i++){
            for (int j = 0 ; j< grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;

    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0||j<0||j>=grid[0].length||i>=grid[0].length||grid[i][j]!=1){
            return;
        }
        grid[i][j] = 0;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    // Boolean help array
    public int numIslands2(char[][] grid) {
        if(grid == null||grid.length==0){
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0 ; i <grid.length;i++){
            for (int j = 0 ; j <grid[0].length;j++){
                //if(grid[i][j]=='1')
                if(grid[i][j]>='5'&&visited[i][j]==false){
                    dfsHelper(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;

    }

    private void dfsHelper(char[][] grid, int i, int j,boolean[][] visited) {
//        if(i<0||j<0||j>grid[0].length||i>grid.length||grid[i][j]<5||visited[i][j]==true){
        if(i<0||j<0||j>=grid[0].length||i>=grid.length||grid[i][j]=='0'||visited[i][j]==true){
            return;
        }
        visited[i][j] = true;
        dfsHelper(grid,i+1,j,visited);
        dfsHelper(grid,i-1,j,visited);
        dfsHelper(grid,i,j+1,visited);
        dfsHelper(grid,i,j-1,visited);
    }

    // 最大的size
    public int PeriofnumIslands(char[][] grid) {
        if(grid == null||grid.length==0){
            return 0;
        }
//        int count = 0;
        int result = 0;
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0 ; i <grid.length;i++){
            for (int j = 0 ; j <grid[0].length;j++){
                //if(grid[i][j]=='1')
                if(grid[i][j]=='1'&&visited[i][j]==false){
                    result =  dfsHelper2(grid,i,j,visited);
                    max = Math.max(result,max);
                }
            }
        }
        return max;

    }

    private int dfsHelper2(char[][] grid, int i, int j,boolean[][] visited) {
//        if(i<0||j<0||j>grid[0].length||i>grid.length||grid[i][j]<5||visited[i][j]==true){
        if(i<0||j<0||j>=grid[0].length||i>=grid.length||grid[i][j]=='0'){
            return 1;
        }
        if(visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return dfsHelper2(grid,i+1,j,visited)+dfsHelper2(grid,i-1,j,visited)
                +dfsHelper2(grid,i,j+1,visited)+dfsHelper2(grid,i,j-1,visited);
    }

    //移除小于k
    static private int m;
    static private int n;
    static private int size;
    public static void numIslands(char[][] grid,int k) {
        m=grid.length;
        if(m==0) return;
        n=grid[0].length;
        boolean[][] bool=new boolean[m][n];
        char[][] temp=new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[i][j] = grid[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(temp[i][j]=='1'){
                    size=0;
                    dfs3(temp,i,j);
                    if(size<k){
                        remove(grid,i,j);
                    }
                }
            }
        }
    }
    public static void dfs3(char[][] grid,int i,int j){
        if(i<0||j<0||i>=m||j>=n||grid[i][j]=='0') return;
        grid[i][j]='0';
        size++;
        dfs3(grid,i,j+1);
        dfs3(grid,i,j-1);
        dfs3(grid,i+1,j);
        dfs3(grid,i-1,j);
    }
    public static void remove(char[][] grid,int i,int j){
        if(i<0||j<0||i>=m||j>=n||grid[i][j]=='0') return;
        grid[i][j]='0';
        remove(grid,i,j+1);
        remove(grid,i,j-1);
        remove(grid,i+1,j);
        remove(grid,i-1,j);
    }
}
