package subcategory.array;

/**
 * Created by yangw on 2019/7/3.
 */
public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        for (int i = 0, temp = 1; i < nums.length ; i++){
            res[i] = temp;
            temp *= res[i];
        }
        for (int i = nums.length - 1, temp = 1 ; i >= 0 ; i++){
            res[i] *= temp;
            temp *= nums[i];
        }

        return res;
    }

}
