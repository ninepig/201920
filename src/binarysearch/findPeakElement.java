package binarysearch;

/**
 * Created by yangw on 2019/6/22.
 * leetcode 162 / 852
 * 暴力法
 * 二分法，二分法我们找到任意一个峰值，然后和后面比即可。因为只要任意一个即可。
 * start的值 肯定比start -1 大
 * end的值 肯定币end+1大 所以比较一哈就可以了
 */
public class findPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return 0;
        }
        int start = 0,end = nums.length-1;
        while (start+1<end){

            int mid = start+(end-start)/2;
            if(nums[mid]>nums[mid+1]){
                end = mid;
            }else {
                start =mid;
            }
        }
        if(nums[start]<nums[end]){
            return end;
        }else {
            return start;
        }

    }
}
