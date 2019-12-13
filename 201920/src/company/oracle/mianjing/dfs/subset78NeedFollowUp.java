package company.oracle.mianjing.dfs;

import java.util.ArrayList;
import java.util.List;

public class subset78NeedFollowUp {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<>(),0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, ArrayList<Object> cur, int pos) {
        res.add(new ArrayList(cur));
        for (int i = pos ; i < nums.length ; i++){
            cur.add(nums[i]);
            helper(nums, res, cur, i+1);
            cur.remove(cur.size() - 1 );
        }
    }
}
