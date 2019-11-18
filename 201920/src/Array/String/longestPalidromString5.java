package Array.String;

/*
 n2
 全局变量 加上全部扫描。 类似暴力的方法。
 两边开的方法
 */
public class longestPalidromString5 {
    int Max = 0;
    int Low = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        if (s.length() < 2){
            return s;
        }
        for (int i = 0 ; i < s.length() - 1; i++){
            helper(s, i , i); // length is odd
            helper(s, i , i + 1); // length is even
        }

        return s.substring(Low, Low + Max);
    }

    private void helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if ( r - l - 1 > Max){
            Low = l + 1; // avoid be -1
            Max = r - l - 1;
        }
    }
}
