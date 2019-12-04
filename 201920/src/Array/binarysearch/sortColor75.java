package Array.binarysearch;

public class sortColor75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int p0 = 0 , index = 0, p2 = nums.length - 1;

        while (index <= p2){
            // put all the 0 at the beginning
            if (nums[index] == 0){
                nums[index] = nums[p0];
                nums[p0] = 0;
                p0++;
                // put all the 2 at the ending
            }else if (nums[index] == 2){
                nums[index] = nums[p2];
                nums[p2] = 2;
                //we dont want it to be index ++, so we need do index-- first
                index--;
                p2--;
            }
            index++;
        }
    }
}

