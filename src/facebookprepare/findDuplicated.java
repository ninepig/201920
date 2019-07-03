package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class findDuplicated {
    public int findDuplicate(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                return index + 1;
            }
            nums[index] = -nums[index];
        }
        return -1;
    }

}
