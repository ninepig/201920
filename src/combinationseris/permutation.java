package combinationseris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2019/6/28.
 * permutation 这类题不会有index的传递，所以需要借助第三方数组来弄。
 */
public class permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();

        helper(nums,new boolean[nums.length -1],cur,res);
        return res;
    }

    private void helper(int[] nums, boolean[] visited, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0 ; i < nums.length ; i++){
            if(visited[i]) {
                continue;
            }
                cur.add(nums[i]);
                visited[i] = true;
                helper(nums,visited,cur,res);
                visited[i] = false;
                cur.remove(cur.size() - 1);

        }
    }

    // 去重问题
    public List<List<Integer>> permuteUnique(int[] nums) {
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
                // 关键是这一句  必须理解
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
