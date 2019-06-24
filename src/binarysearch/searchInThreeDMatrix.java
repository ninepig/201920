package binarysearch;

/**
 * Created by yangw on 2019/6/22.
 * Leetcode 74 && 240
 * 虽然不是二分法，也是利用二分法的思想，不断舍弃不合适的。
 * 74 是row 排序
 * 240 是colunm 排序
 * 算法一模一样。。
 */
public class searchInThreeDMatrix {
    public boolean searchMatrix(int[][] matrix , int target){
        if(matrix == null || matrix.length == 0) return false;
        int x = matrix.length - 1;
        int y = 0;

        while(x >= 0 && y < matrix[0].length){
            int current = matrix[x][y];
            if (current == target) return true;
            else if (current < target) y++;
            else x--;
        }

        return false;
    }
}
