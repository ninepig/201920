package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class uniquePath {
    public int uniquePaths(int m, int n) {
        if(m==1&&n==1){
            return 1;
        }
        //initial state
        int[][] dp = new int[m][n];

        //initial
        for(int i = 0; i<m;i++){
            dp[i][0] = 1;
        }
        for(int j = 0 ; j<n;j++){
            dp[0][j] = 1;
        }

        //state transfer
        for(int i = 1 ; i<m;i++){
            for (int j = 1 ; j< n ; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}
