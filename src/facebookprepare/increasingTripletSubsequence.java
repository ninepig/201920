package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class increasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        int min = Integer.MAX_VALUE,secMin =Integer.MAX_VALUE;

        for(int num:nums){
            if(num<=min){
                min = num;
            }else if(num<=secMin){
                secMin = num;
            }else{
                return true;
            }
        }
        return false;
    }
}
