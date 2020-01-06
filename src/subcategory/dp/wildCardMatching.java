package subcategory.dp;

import java.util.Arrays;

/**
 * Created by yangw on 2019/7/6.
 */
public class wildCardMatching {
    public boolean isMatch(String s, String p) {

        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0]= true;

        for(int i=1;i<=p.length();i++)
            if(p.charAt(i-1)=='*')
                match[0][i]= match[0][i-1];

        for(int i=1;i<=s.length();i++)
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1)!='*')
                    match[i][j]=match[i-1][j-1] && (p.charAt(j-1)=='?' || s.charAt(i-1)== p.charAt(j-1));
                else
                    match[i][j]=match[i][j-1] || match[i-1][j] ;
            }
        return match[s.length()][p.length()];
    }

    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }

        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0; i<=amount; i++){
            if(dp[i]==Integer.MAX_VALUE){
                continue;
            }

            for(int coin: coins){
                if(i<=amount-coin){ //handle case when coin is Integer.MAX_VALUE
                    dp[i+coin] = Math.min(dp[i]+1, dp[i+coin]);
                }
            }
        }

        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }

        return dp[amount];
    }
}
