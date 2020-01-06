package subcategory.array;

/**
 * Created by yangw on 2019/7/4.
 */
public class rangeSumserial {

    // One d , immutalble
    class NumArray {
        int[] sum;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;// Throws exception
            }
            sum = new int[nums.length];
            sum[0] = nums[0];
            // Prefix sum array
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? sum[j] : sum[j] - sum[i];
        }
    }

    // one d, mutable
    class NumArray2{
        int[] nums;
        int[] BIT;
        int n;

        public NumArray2(int[] nums) {
            this.nums = nums;

            n = nums.length;
            BIT = new int[n + 1];
            for (int i = 0; i < n; i++)
                init(i, nums[i]);
        }

        public void init(int i, int val) {
            i++;
            while (i <= n) {
                BIT[i] += val;
                i += (i & -i);
            }
        }

        void update(int i, int val) {
            int diff = val - nums[i];
            nums[i] = val;
            init(i, diff);
        }

        public int getSum(int i) {
            int sum = 0;
            i++;
            while (i > 0) {
                sum += BIT[i];
                i -= (i & -i);
            }
            return sum;
        }

        public int sumRange(int i, int j) {
            return getSum(j) - getSum(i - 1);
        }

    }
    // two d imuutalble
    class NumMatrix {
        private int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix == null
                    || matrix.length == 0
                    || matrix[0].length == 0) {
                return;
            }

            int m = matrix.length;
            int n = matrix[0].length;

            dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int iMin = Math.min(row1, row2);
            int iMax = Math.max(row1, row2);

            int jMin = Math.min(col1, col2);
            int jMax = Math.max(col1, col2);

            return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
        }
    }

    public class NumMatrix2d {
        private int BIT2D[][];
        private int matrix[][];

        public NumMatrix2d(int[][] matrix) {
            if(matrix == null || matrix.length == 0) {
                return;
            }
            BIT2D = new int[matrix.length + 1][matrix[0].length + 1];
            this.matrix = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            int delta = val - matrix[row][col];
            matrix[row][col] = val;
            for(int i = row + 1; i < BIT2D.length; i += i & (-i)) {         //also equals to i |= i + 1
                for(int j = col + 1; j < BIT2D[0].length; j += j & (-j)) {
                    BIT2D[i][j] += delta;
                }
            }
        }


        public int sumRegion(int row1, int col1, int row2, int col2) {
            return getSum(row2 + 1, col2 + 1) - getSum(row1, col2 + 1) - getSum(row2 + 1, col1) + getSum(row1, col1);
        }

        private int getSum(int row, int col) {
            int sum = 0;
            for(int i = row; i > 0; i -= i & (-i)) {
                for(int j = col; j > 0; j -= j & (-j)) {
                    sum += BIT2D[i][j];
                }
            }
            return sum;
        }
    }

}
