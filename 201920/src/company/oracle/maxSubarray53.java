package company.oracle;

// 贪心的一道题
public class maxSubarray53 {
    public int maxSubArray(int[] nums) {
        if ( nums == null || nums.length == 0) return 0;
        int global = nums[0];
        int local = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            // 对于local来说，它取决于之前的local 加上当前的  和当前的比较 最大的！
            // 当前值的改变，对于local 值的改变。
            local  = Math.max(local + nums[i] , nums[i] );
            global = Math.max(local, global);
        }
        return global;
    }
}