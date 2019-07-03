package combinationseris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/6/28.
 */
public class palindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        helper(s, res, cur,0);
        return res;

    }

    private void helper(String s, List<List<String>> res, List<String> cur, int pos) {
            if (pos == s.length()){
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = pos ; i < s.length() ; i++){
                String subString = s.substring(pos, i + 1);
                if (!isPalindrome(subString)){
                    continue;
                }
                cur.add(subString);
                helper(s,res,cur,i+1);
                cur.remove(cur.size()-1);
            }
    }

    private boolean isPalindrome(String subString) {
        int l = 0 , r = subString.length() - 1;

        while (l < r){
            if (subString.charAt(l)!=subString.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}