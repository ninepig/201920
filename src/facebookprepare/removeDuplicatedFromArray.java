package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class removeDuplicatedFromArray {
    public int removeDuplicates(int[] nums) {

     if(nums == null || nums.length == 0){
        return 0;
    }
    int temp = nums[0];
    int index = 1;
        for(int i = 1 ; i < nums.length ; i++){
        if(temp != nums[i]){
            nums[index++] = nums[i];
            temp = nums[i];
        }
    }
        return index;
}}
