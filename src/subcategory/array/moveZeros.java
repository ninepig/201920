package subcategory.array;

/**
 * Created by yangw on 2019/7/6.
 */
public class moveZeros {
    // two pass
    public void moveZeroes1(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        int noZeroIndex = 0 ;
        for(int i = 0 ; i < nums.length;i++){
            if(nums[i]!=0){
                nums[noZeroIndex] = nums[i];
                noZeroIndex++;
            }
        }
        for(int i = noZeroIndex; i< nums.length;i++){
            nums[i] = 0 ;
        }
    }

    // swap version
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

}
