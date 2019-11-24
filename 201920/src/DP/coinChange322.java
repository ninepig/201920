package DP;

import java.util.Arrays;

public class coinChange322 {
    public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length ==0) return -1;
            if (amount < 1 ) return 0;
            int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
            for ( int coin : coins){
                for (int i = coin ; i <= amount ; i++){
                    if (dp[i - coin] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i] , dp[i - coin] + 1);
                    }
                }
            }

            return dp[amount]  == Integer.MAX_VALUE ?  -1 : dp[amount];
    }
}