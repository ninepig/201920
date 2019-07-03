package combinationseris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2019/6/28.
 */
public class combinationSum {


    // can be used more than once
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(res,cur,target,0,candidates);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int target, int pos, int[] candidates) {
        if(target < 0){
            return ;
        }
        //Ending condition
        if (target == 0){
            res.add(new ArrayList<>(cur));
        }

        for (int i = pos ; i <candidates.length ; i++){
            cur.add(candidates[i]);
            helper(res,cur,target-candidates[i],i,candidates);
            cur.remove(cur.size() -1 );
        }
    }

    // remove duplicate
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        helper2(candidates,res,cur,target,0);
        return res;
    }

    private void helper2(int[] candidates, List<List<Integer>> res,List<Integer> cur,int target , int pos){
        if(target < 0){
            return;
        }else if (target == 0){
            res.add(new ArrayList(cur));
        }else{
            for(int i = pos ; i < candidates.length ; i++){
                // Remove duplicated
                if(i != pos && candidates[i-1] == candidates[i]){
                    continue;
                }
                cur.add(candidates[i]);
                helper2(candidates,res,cur,target-candidates[i],i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
    // K number and sum to n
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n < 0) return  null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper3(res,cur,k,1,n);

    return res;

    }

    private void helper3(List<List<Integer>> res, List<Integer> cur, int k, int start, int target) {
        if (cur.size() == k && target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }else {
            for (int i = start ; i <= 9 ; i++){
                cur.add(i);
                helper3(res,cur,k,i+1,target-1);
                cur.remove(cur.size()-1);
            }
        }
    }
}
