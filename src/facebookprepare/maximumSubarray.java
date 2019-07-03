package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class maximumSubarray {
    public int maxSubArray(int[] nums) {
        int local = nums[0];
        int global = nums[0];
        for(int i = 0 ; i < nums.length ; i++){

            // Local 的概念是当前这个点和之前所有点之和比较
            local = Math.max(nums[i],nums[i] + local);
            global = Math.max(local,global);
        }
        return global;
    }
}
