package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class maxProductOfThreeNumber {
    public int maximumProduct(int[] nums) {
        int bigger1=Integer.MIN_VALUE,bigger2= Integer.MIN_VALUE,bigger3 =Integer.MIN_VALUE;
        int small1= Integer.MAX_VALUE, samller2 =Integer.MIN_VALUE;

        for (int i = 0; i<nums.length;i++){
            if(nums[i]>bigger1){
                bigger3 =bigger2;
                bigger2 = bigger1;
                bigger1 = nums[i];
            }else if (nums[i]>bigger2){
                bigger3 =bigger2;
                bigger2 = nums[i];
            }else if(nums[i]>bigger3){
                bigger3 = nums[i];
            }
            if(nums[i]<small1){
                samller2 = small1;
                small1 = nums[i];
            }else if(nums[i]<samller2){
                samller2 = nums[i];
            }
        }

        return Math.max(bigger1*bigger2*bigger3,samller2*small1*bigger1);

    }
}
}
