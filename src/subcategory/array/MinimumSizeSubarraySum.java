package subcategory.array;

/**
 * Created by yangw on 2019/7/7.
 */
public class MinimumSizeSubarraySum {
     public int minSubArrayLen(int s, int[] nums) {
              if(nums==null||nums.length==0){
             return 0;
         }
         int i = 0, j = 0 , res = Integer.MAX_VALUE;
         int sum = 0;
         for (i = 0;i<nums.length;i++){
             sum +=nums[i];
             while(sum>=s){
                 res = Math.min(res,i-j+1);
                 sum-=nums[j];
                 j++;
             }
         }
         return res==Integer.MAX_VALUE?0:res;
}
}
