package company.oracle;

public class stockSerial121 {
    // One transaction
    // Similar idea of local & global
    public int maxProfitI(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int lowest = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length ; i++){
            if (prices[i] < lowest){
                lowest = prices[i];
            }

            max  = Math.max(max , prices[i] - lowest);
        }
        return max;
    }
    // Mult transaction
    public int maxProfitII(int[] prices) {
        if(prices == null || prices.length <=1 ) return  0;
        int profit = 0;
        for (int i = 1 ; i < prices.length ; i++){
            if (prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return  profit;
    }

    // maxTwo
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int sell1 = 0 , sell2 = 0 , buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for(int i = 0 ; i<prices.length;i++){
            // buying price, smaller the better,
            buy1 = Math.max(buy1,-prices[i]);
            // after sell first stock. the more the better,we put the money and prices we sell together
            sell1 = Math.max(sell1,prices[i]+buy1);
            buy2 = Math.max(buy2,sell1-prices[i]);
            sell2 = Math.max(sell2,prices[i]+buy2);
        }
        return sell2;
    }

    // K transactions
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
