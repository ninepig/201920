package facebookprepare;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/2.
 */
public class generateParethesis {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        helper(res,n,0,0,"");
        return res;
    }

    private void helper(List<String> res, int n, int left, int right,String s) {
        if(s.length() == 2 * n){
            res.add(s);
        }else{
            if(left < n){
                helper(res,n,left + 1 ,right,s + "(");
            }
            if(right < left){
                helper(res, n, left,right+1,s+")");
            }
        }
    }
}
