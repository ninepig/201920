package facebookprepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2019/6/28.
 */
public class subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        helper(nums,res,cur,0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, int pos) {
        res.add(new ArrayList(cur));
        for (int i = pos ; i < nums.length ; i++){
            cur.add(nums[i]);
            helper(nums,res,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }
    // Duplicated situtation
    // 凡是出现duplicated的问题 一定要考虑排序。 这样才能去重
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        helper2(nums,cur,res,0);
        return res;
    }

    private void helper2(int[] nums, List<Integer> cur, List<List<Integer>> res, int pos) {
        res.add(new ArrayList(cur));
        for (int i = pos ; i < nums.length ;i++){
            // 比较去重的估计公式
            if (i != pos || nums[i-1] == nums[i]){
                continue;
            }
            cur.add(nums[i]);
            helper2(nums,cur,res,i+1);
            cur.remove(cur.size()-1);
        }
    }
}
