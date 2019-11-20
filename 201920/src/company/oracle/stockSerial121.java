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
}
