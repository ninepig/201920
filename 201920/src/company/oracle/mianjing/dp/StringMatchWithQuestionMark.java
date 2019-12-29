package company.oracle.mianjing.dp;

public class StringMatchWithQuestionMark {
    // a means pattern b could have ?
    // 有一个follow up?
    //I used recursive. Recquire O(2**N)time complexity. Then create a set to save visited case to save some time.
    public boolean stringMatchingWithQuestionMart(String a , String b){
        if (a == null || b == null ) return false;
        if (a.length() != b.length() ) return  false;
        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
        dp[0][0] =  true;

        for (int i = 1 ; i <= a.length() ; i++){
            for (int j = 1 ; j <= b.length(); j++){
                dp[i][j] = dp[i - 1][j - 1] && (a.charAt(i) == '?' || a.charAt(i) == b.charAt(j));
            }
        }
        return dp[a.length()][b.length()];
    }
}
