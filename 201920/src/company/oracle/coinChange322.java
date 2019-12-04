package company.oracle;

import java.util.Arrays;

/*
state dp[i]  i means amount number , dp[i] means getting to amount i , at least how much coin we needs
initial state dp[0] = 0
state transfer
amount - coin =  minCoins - 1
dp[i - coin ] = dp[i] - 1
dp[i] = Math. min (dp[i] , dp[i - coin]
 */
public class coinChange322 {
    // bottom - up
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



    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount < 1) return 0;
            return coinChange(coins, amount, new int[amount]);
        }
        private int coinChange(int[] coins, int rem, int[] count) {
            if (rem < 0) return -1;
            if (rem == 0) return 0;
            if (count[rem - 1] != 0) return count[rem - 1];
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min)
                    min = 1 + res;
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }
    }
}