package Array.brain;

/*
http://rainykat.blogspot.com/2017/01/leetcode-238-product-of-array-except.html
如果能用除法 是最简单的
如果不能用除法，
每一个数都是从左乘到这个数乘以从右乘到左的积
 */
public class productExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null|| nums.length == 0) return nums;
        int left = 1 , right =1;
        int[] res = new int[nums.length];
        res[0] = 1;
        // from left , so we skip first one.
        for (int i = 1 ; i < nums.length ;i++){
            left = left * nums[i - 1];
            res[i] = left;
        }

        // from right , so we skip last one.
        for (int i = nums.length - 2 ; i >= 0 ; i--){
            right = right * nums[i + 1];
            // from here, we need use *= to set the final value.
            // Last digit all ready be the all left digit times together.
            res[i] *= right;
        }

        return res;
    }
}
