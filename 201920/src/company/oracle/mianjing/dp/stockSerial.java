package company.oracle.mianjing.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
public class stockSerial {
    public int stockOne(int[] stocks) {

        if (stocks == null || stocks.length == 0) return -1;
        int max = 0;
        int lowest = 0;
        for (int i = 0; i < stocks.length; i++) {
            if (stocks[i] < lowest) {
                lowest = stocks[i];
            }
            max = Math.max(max, stocks[i] - lowest);
        }

        return max;

    }

    public int stockTwo(int[] stocks) {
        if (stocks == null || stocks.length == 0) return -1;
        int res = 0;
        for (int i = 1; i < stocks.length; i++) {
            if (stocks[i] > stocks[i - 1]) {
                res += stocks[i] - stocks[i - 1];
            }
        }
        return res;
    }

    /*
    We can also explain the above codes in other words.
    On every day, we buy the share with the price as low as we can,
    and sell the share with price as high as we can. For the second transaction,
    we integrate the profit of first transaction into the cost of the second buy, then the profit of the second sell will be the total profit of two transactions.

     */
    public int stockWithTwoTrans(int[] stocks) {
        if (stocks == null || stocks.length == 0) return -1;
        int sell1 = 0, sell2 = 0, buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        for (int i = 0; i < stocks.length; i++) {
            buy1 = Math.min(buy1, stocks[i]);
            sell1 = Math.max(sell1, stocks[i] - buy1);
            // Cost contain our sell1 profit. (stocks[i] - sell1)
            buy2 = Math.min(buy2, stocks[i] - sell1);
            //Profit after transaction2.
            sell2 = Math.max(sell2, stocks[i] - buy2);
        }
        return sell2;
    }

    /*
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >= n / 2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    maxPro += prices[i] - prices[i - 1];
            }
            return maxPro;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                // Dp[i][j] means either we did this transaction with this stock or not selling. get the max one.
                // LocalMax is max after we buy this stock.
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108871/2-solutions-2-states-DP-solutions-clear-explanation
    public int maxProfitWithTracationFee(int[] prices , int fee){
        if (prices == null || prices.length == 0) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length ; i++){
            // We either dont sell or we sell today.
            buy[i] = Math.max(buy[i-1] , sell[i-1] - prices[i]);
            // We either don't sell anything or we sell from previous day.
            sell[i] = Math.max(sell[i-1] , buy[i-1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }

}