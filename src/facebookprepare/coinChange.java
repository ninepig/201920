package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class coinChange {
    public int coinChange(int[] coins , int amount){
        if(amount < 1) return 0;
        // initial state
        int[] dp = new int[amount + 1];
        int sum = 0 ;
        while (++sum <= amount){
            int min = -1;
            for (int coin : coins){
                if(sum >= coin && dp[sum - coin] != -1){
                    int temp = dp[sum - coin] + 1;
                    // if min never be set, use temp value otherwise get the smaller value.
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }
}
