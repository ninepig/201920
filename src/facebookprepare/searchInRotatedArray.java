package facebookprepare;

/**
 * Created by yangw on 2019/6/22.
 * leetcode 33
 * 超级经典题了
 * follow up
 * 就是考虑duplicate的问题
 */
public class searchInRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1 ;
        }
        int l = 0 , r = nums.length - 1 ;
        while ( l + 1 < r){
            int mid = l + (r - l ) / 2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > nums[r]){
                if(target <= nums[mid] && target>= nums[l]){
                    r = mid;
                }else{
                    l = mid;
                }
            }else if(nums[mid] < nums[r]){
              if(target >= nums[mid] && target <= nums[r] ){
                  l = mid;
              }else{
                  r = mid;
              }
            }
        }
        if(nums[l] == target) return l;
        if(nums[r] == target ) return r;
        return -1;
    }

    public boolean search2(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return true;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[start]) {
                if (nums[mid] < target && target < nums[start]) {
                    start = mid;
                } else {
                    end = mid;
                }
                // need to take care of duplication
            } else {
                start++;
            }
        }
        if (nums[start] == target) {
            return true;
        }

        if (nums[end] == target) {
            return true;
        }
        return false;
    }
}