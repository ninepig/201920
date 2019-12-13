package company.oracle.mianjing.array;

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

/*
dp[amount]  least coin you need to get that
// coin means different coin number
dp[i] = min(dp[i], dp[i - coin]) + 1
 */
//    dp status: dp[price] = least coin counts
//    dp equation: dp[i] = Math.min(dp[i-coins[0..j]) + 1

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            for (int i = 1; i < dp.length; i++) {
                dp[i] = dp.length;
                for (int j = 0; j < coins.length; j++) {
                    if (i >= coins[j]) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            return dp[amount] == dp.length ? -1 : dp[amount];
        }
    }

    // bottom - up
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    class Solution2 {
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


    // bottom - up
    public int coinChangeR(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    //sorting coins array into ascending order so that we can early termination.

    public class SolutionSorting {
        public int coinChange(int[] coins, int amount) {
            // DP, time complexity: O(ClogC + amount / smallest_coin), C = |coins|
            // space complexity: O(amount)
            // opt[i] = min_j(opt[j]) + 1 if j - i is a denomination in coins
            Arrays.sort(coins);
            int[] opt = new int[amount + 1];
            opt[0] = 0;
            for (int i = 1; i <= amount; i++) {
                opt[i] = Integer.MAX_VALUE;
                for (int c : coins) {
                    if (i >= c) {
                        if (opt[i - c] != Integer.MAX_VALUE) {
                            opt[i] = Math.min(opt[i], opt[i - c] + 1);
                        }
                    } else {
                        break;
                    }
                }
            }
            return opt[amount] == Integer.MAX_VALUE ? -1 : opt[amount];
        }
    }

    public class SolutionBrutalForce {

        public int coinChange(int[] coins, int amount) {
            return coinChange(0, coins, amount);
        }

        private int coinChange(int idxCoin, int[] coins, int amount) {
            if (amount == 0)
                return 0;
            if (idxCoin < coins.length && amount > 0) {
                int maxVal = amount/coins[idxCoin];
                int minCost = Integer.MAX_VALUE;
                for (int x = 0; x <= maxVal; x++) {
                    if (amount >= x * coins[idxCoin]) {
                        int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                        if (res != -1)
                            minCost = Math.min(minCost, res + x);
                    }
                }
                return (minCost == Integer.MAX_VALUE)? -1: minCost;
            }
            return -1;
        }
    }


}