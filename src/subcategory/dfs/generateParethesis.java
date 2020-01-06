package subcategory.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/6.
 * 经典老题
 */
public class generateParethesis {
    public List<String> generateParethesis(int number){
        if (number<=0) return null;
        List<String> res = new ArrayList<>();
        dfs(0,0,number,res,"");
        return res;
    }

    private void dfs(int l , int r, int number, List<String> res, String curRes) {
        if (curRes.length() ==  2* number){
            res.add(curRes);
        }
        if (l < number){
            dfs(l+1,r,number,res,curRes+"(");
        }
        if (r < l){
            dfs(l,r+1,number,res,curRes+")");
        }
    }
}
