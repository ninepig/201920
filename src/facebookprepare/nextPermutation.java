package facebookprepare;

/**
 * Created by yangw on 2019/6/30.
 */
public class nextPermutation {
    public void nextPermutation(int[] nums){
        if(nums == null || nums.length == 0) return;

        // 314254
        // Find first decreseasing number from end
        // 2
        int i = nums.length - 2;
        while(i>= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        // find first number bigger than 2 from end
        if(i >= 0 ){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            // swap 2 and 4
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums,i+1);
    }

    private void reverse(int[] nums, int i) {
        int l = i, r = nums.length - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
