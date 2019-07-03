package facebookprepare;

/**
 * Created by yangw on 2019/7/1.
 */
public class decodeWay {
    public int numDecodings(String s) {


        if(s==null||s.length()==0){
            return 0;
        }
        //inital state, dp[0]means empty string can decode 1way
        // dp[1] means charAt 0 , if it is 0 we have 0 way to decode,other wise we have 1 way
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;

        for(int i =2 ;i<=s.length();i++){
            //state transfer we have two kind of transfer functon
            // if if current digit 1--9, we need count dp[i]+=dp[i-1]
            int oneDigit = Integer.valueOf(s.substring(i-1,i));
            //if it two digit 10--26, we need count dp[i]+=dp[i-2];
            int twoDigit = Integer.valueOf(s.substring(i-2,i));
            if(oneDigit>0&&oneDigit<=9){
                dp[i]+=dp[i-1];
            }
            if(twoDigit>=10&&twoDigit<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
