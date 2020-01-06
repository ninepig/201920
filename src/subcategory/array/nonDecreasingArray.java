package subcategory.array;

/**
 * Created by yangw on 2019/7/2.
 */
public class nonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int modified = 0;
        for(int i = 1 ; i< nums.length;i++){
            if(nums[i]<nums[i-1]){
                modified++;
                if(modified>1){
                    return false;
                }
                if(i-2<0||nums[i-2]<=nums[i]){
                    nums[i-1] = nums[i];
                }else {
                    nums[i] = nums[i-1];
                }

            }

        }
        return true;
    }
}
