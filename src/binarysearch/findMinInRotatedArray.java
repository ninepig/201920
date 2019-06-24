package binarysearch;

/**
 * Created by yangw on 2019/6/23.
 * leetcode 153/152
 * 二分法的思想
 * 这道题类似findTargetInRoatedArray
 */
public class findMinInRotatedArray {
    // Unrotated version
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0 , r = nums.length - 1;
        // Find the left and right of pivot.
        while (l + 1 < r){
            int mid = l + (r - l)/2;
            if(nums[mid] < nums[r]){
                r = mid;
            }else {
                l = mid;
            }
        }
        return Math.min(nums[l],nums[r]);
    }


    public int findMinDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                end--;
            } else if (nums[mid] < nums[end]) {
                end = mid;
                // of course you can merge == & <
            } else {
                start = mid;
                // or start = mid + 1
            }
        }

        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}
