package facebookprepare;

/**
 * Created by yangw on 2019/7/1.
 */
public class targetSum {
    public class Solution {
        int result = 0;

        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0) return result;
            helper(nums, S, 0, 0);
            return result;
        }

        public void helper(int[] nums, int target, int pos, long eval){
            if (pos == nums.length) {
                if (target == eval) result++;
                return;
            }
            helper(nums, target, pos + 1, eval + nums[pos]);
            helper(nums, target, pos + 1, eval - nums[pos]);
        }
    }
   // Optimization: The idea is If the sum of all elements left is smaller than absolute value of target, there will be no answer following the current path. Thus we can return.

        int result = 0;

        public int findTargetSumWays2(int[] nums, int S) {
            if(nums == null || nums.length == 0) return result;

            int n = nums.length;
            int[] sums = new int[n];
            sums[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--)
                sums[i] = sums[i + 1] + nums[i];

            helper2(nums, sums, S, 0);
            return result;
        }
        public void helper2(int[] nums, int[] sums, int target, int pos){
            if(pos == nums.length){
                if(target == 0) result++;
                return;
            }

            if (sums[pos] < Math.abs(target)) return;

            helper2(nums, sums, target + nums[pos], pos + 1);
            helper2(nums, sums, target - nums[pos], pos + 1);
        }

}
