package company.oracle.mianjing.array;

public class sortColor75 {
    public void sortColorsTwoPass(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int zeroCount = 0, oneCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroCount++;
            else if (nums[i] == 1) oneCount++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < zeroCount) {
                nums[i] = 0;
            } else if (i < (zeroCount + oneCount) && i >= zeroCount) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
    // 关键想明白三个指针
    public void sortColors(int[] nums) {
        int p0 = 0 , p2 = nums.length - 1;
        int index = 0;
        while (index <= p2){
            if (nums[index] == 0){
                nums[index] = nums[p0];
                nums[p0] = 0;
                p0++;
            }else if(nums[index]==2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
}