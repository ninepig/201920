package subcategory.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/3.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num==null||num.length()==0){
            return res;
        }
        helper(res,"",num,target,0,0,0);
        return res;
    }

    private void helper(List<String> res, String curRes, String num, int target, int pos, long eval, long mult){
        if(pos == num.length()){
            if(target ==eval ){
                res.add(curRes);
            }
        }else{
            for(int i = pos; i<num.length();i++){
                if(i!=pos&&num.charAt(pos)=='0') break;
                long cur = Long.parseLong(num.substring(pos,i+1));
                if(pos==0){
                    helper(res,curRes+cur,num,target,i+1,cur,cur);
                }else {
                    helper(res,curRes+"+"+cur,num,target,i+1,eval+cur,cur);
                    helper(res,curRes+"-"+cur,num,target,i+1,eval-cur,-cur);
                    /*
                    for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your eval is 6 right?
                     If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied, so you want to take it out from the existing eval.
                    You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4). Hope this could help : )
                     */
                    helper(res,curRes+"*"+cur,num,target,i+1,eval-mult+mult*cur,mult*cur);
                }

            }
        }
    }

}
