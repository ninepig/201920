package company.oracle.lastweekDash;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import tree.TreeNode;

public class onsite927IAM {
    /*
    https://www.1point3acres.com/bbs/thread-558749-1-1.html

第一轮： check balanced binary tree, world ladder I 加几个BQ，
第二轮： HM 吃饭， 加BQ，
第三轮:   inorder BT， 需要iterator 方法，没有要求写 莫里斯的方法。 输入除了一个root，还有另一个自建object，对每个tree node做相应操作(打印之类的操作, 会讨论些edge cases，
第四轮： bar raiser吧估计， 别组的，视频面试，写了个斐波那契热身，然后来了个发牌的OOD，shuffle用java自带的API就可以，面试官主要看对java的内置API的熟练度，中途说了如果已经有了API，就不需要写code自己再实现。
第五轮： number of island I，加一堆变种，比如最大岛的面积，比如有各种各样的岛，
     */
    boolean ifBalab = true;
    public boolean balancedTree(TreeNode root){
            if (root == null) return false;
            helper(root);
            return ifBalab;
    }
    int helper(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1 ){
            ifBalab = false;
        }
        return  Math.max(left,right) + 1;
    }



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

}
