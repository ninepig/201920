package company.oracle.onsiteMianjing;


//https://algorithms.tutorialhorizon.com/dynamic-programming-minimum-cost-path-problem/
// 。2维数组里存的是cost，从左上角走到右下角，只能往右或往下，求最小cost
public class minCostCrossArray {
    public int minCost(int[][] matrix){
        if (matrix == null || matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length +1];
        dp[0][0] = 0;
        for (int i = 1 ; i < dp.length ; i++){
            dp[i][0] = dp[i-1][0] + matrix[i-1][0];
        }
        for (int i = 1 ; i < dp[0].length;i++){
            dp[0][i] = dp[0][i-1] + matrix[0][i-1];
        }

//        for (int i = 1 ; i < dp.length - 1 ; i++){
//            for (int j = 1 ; j < dp[0].length - 1; j++){
//                dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + matrix[ i-1 ][j-1];
//            }
//        }

        // 正确的做法接近了
        for (int i = 1 ; i < matrix.length  ; i++){
            for (int j = 1 ; j < matrix[0].length ; j++){
                dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + matrix[i][j];
            }
        }
        return dp[matrix.length - 1] [matrix[0].length - 1];

    }


    // 正确的
    public static int find(int[][] A) {
        int[][] solution = new int[A.length][A.length];

        // 不用考虑 dp[0][0] 等于0的问题， 直接设成A 0 0 即可。 这个想明白就出来了
        solution[0][0] = A[0][0];
        // fill the first row
        for (int i = 1; i < A.length; i++) {
            solution[0][i] = A[0][i] + solution[0][i - 1];
        }

        // fill the first column
        for (int i = 1; i < A.length; i++) {
            solution[i][0] = A[i][0] + solution[i - 1][0];
        }

        // path will be either from top or left, choose which ever is minimum
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                solution[i][j] = A[i][j]
                        + Math.min(solution[i - 1][j], solution[i][j - 1]);
            }
        }
        return solution[A.length - 1][A.length - 1];
    }
}
