package subcategory.array;

/**
 * Created by yangw on 2019/7/2.
 */
public class sortColor {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length-1 , index = 0;
        while(index <= p2){
            if(nums[index] == 0){
                nums[index] = nums[p0];
                nums[p0] = 0;
                p0++;
            }else if (nums[index] == 2){
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
    public void sortColors2(int[] nums) {

        int zeroCount = 0;
    int oneCount = 0;
    int twoCount = 0;
        for(int i = 0 ; i < nums.length ; i++){
        if(nums[i] == 0){
            zeroCount++;
        }else if(nums[i] == 1){
            oneCount++;
        }else{
            twoCount++;
        }
    }
        for(int i = 0; i < nums.length ; i++){
        if(i < zeroCount){
            nums[i] = 0;
        }else if (i < zeroCount + oneCount){
            nums[i] = 1;
        }else{
            nums[i] = 2;
        }
    }
}
}
