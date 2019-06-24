package binarysearch;

/**
 * Created by yangw on 2019/6/23.
 * leetcode 704 最基本的bs 一眼就会
 */
public class binarySearch {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1 ;
        int l = 0 , r  = nums.length -1 ;

        while(l + 1 < r){
            int mid = l + (r - l ) / 2 ;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                r = mid ;
            } else{
                l = mid;
            }
        }
        if(nums[l] == target) return l;
        if(nums[r] == target) return r;
        return -1;
    }
}
