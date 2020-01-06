package subcategory.dp;

/**
 * Created by yangw on 2019/7/6.
 */
public class decodeways {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public int numDecodingsOne(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {//remember to add s.charAt(0)=='0' !!!eg."0" should return 0
            return 0;
        }
        int c1 = 1;//decode ways of s[i-1]
        int c2 = 1;//decode ways of s[i-2]
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c1 = 0;//if s.charAt(i) is 0, it can't be used as a single digit, so set c1 = 0
            }
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                c1 = c1 + c2;//if s.charAt(i) and s.charAt(i-1) can work together as a digit, update c1 to c1+c2
                c2 = c1 - c2;//update c2 to previous c1
            } else {//if s.charAt(i) can only work as a single digit,no new decode ways are added,eg.12 has 2 ways,123 is same
                c2 = c1;//c1 = c1 is omitted, update c2 = c1
            }
        }
        return c1;
    }
}
