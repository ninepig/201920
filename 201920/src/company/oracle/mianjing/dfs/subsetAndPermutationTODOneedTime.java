package company.oracle.mianjing.dfs;

import java.util.ArrayList;
import java.util.List;

public class subsetAndPermutationTODOneedTime {
    class solution{
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums == null || nums.length == 0) return res;

            List<Integer> cur = new ArrayList<>();
            helper(res,cur, nums, 0);

            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> cur , int[] nums, int pos){
            if(cur.size() == nums.length){
                res.add(new ArrayList(cur));
                return;
            }else{
                for(int i = pos ; i < nums.length ; i++){
                    if(cur.contains(nums[pos])){
                        continue;
                    }
                    cur.add(nums[pos]);
                    helper(res, cur, nums,pos);
                    cur.remove(cur.size() - 1 );
                }
            }

        }

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
}
