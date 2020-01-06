package subcategory.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2019/7/2.
 */
public class permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        helper(res,cur,nums,0);
        return res;
    }

    private void helper(List<List<Integer>> res,List<Integer> cur,int[] nums, int pos){
        if(cur.size() == nums.length){
            res.add(new ArrayList(cur));
            return;
        }else{
            for(int i = pos ; i < nums.length ; i++){
                if(cur.contains(nums[i])){
                    continue;
                }
                cur.add(nums[i]);
                helper(res,cur,nums,pos);
                cur.remove(cur.size()-1);
            }
        }
    }


    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0){
            return res;
        }
        List<Integer> cur = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] ifUsed = new boolean[nums.length];

        helper(res,cur,ifUsed,nums);

        return res;
    }

    private void helper(List<List<Integer>> res,List<Integer> cur,boolean[] used,int[] nums){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
        }else{
            for (int i = 0 ; i<nums.length;i++){
                if(used[i]){
                    continue;
                }
                //112  if we want to use second 1 ,the first 1 must be used.
                if(i>0&&nums[i-1]==nums[i]&&(!used[i-1])){
                    continue;
                }
                used[i] = true;
                cur.add(nums[i]);
                helper(res,cur,used,nums);
                cur.remove(cur.size()-1);
                used[i]=false;
            }
        }
    }
}
