package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class diagnalsTravel {
//    Walk patterns:
//
//    If out of bottom border (row >= m) then row = m - 1; col += 2; change walk direction.
//if out of right border (col >= n) then col = n - 1; row += 2; change walk direction.
//if out of top border (row < 0) then row = 0; change walk direction.
//if out of left border (col < 0) then col = 0; change walk direction.
//            Otherwise, just go along with the current direction.
//    Time complexity: O(m * n), m = number of rows, n = number of columns.
//    Space complexity: O(1).

    public class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return new int[0];
            int m = matrix.length, n = matrix[0].length;

            int[] result = new int[m * n];
            int row = 0, col = 0, d = 0;
            int[][] dirs = {{-1, 1}, {1, -1}};

            for (int i = 0; i < m * n; i++) {
                result[i] = matrix[row][col];
                row += dirs[d][0];
                col += dirs[d][1];

                if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
                if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
                if (row < 0)  { row = 0; d = 1 - d;}
                if (col < 0)  { col = 0; d = 1 - d;}
            }

            return result;
        }
    }
}
