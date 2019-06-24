package binarysearch;

/**
 * Created by yangw on 2019/6/22.
 * leetcode 34
 * 初学者的二分法大集合
 */
public class firstAndLastPostOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        int left = 0, right = nums.length - 1;
        int leftIndex = -1 , rightIndex = -1;

        while (left + 1 < right){
            int mid = left + (right - left) / 2 ;
            if(nums[mid] == target){
                right = mid;
            }else if (nums[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }

        if(nums[left] == target){
            leftIndex = left;
        }else if (nums[right] == target){
            leftIndex = right;
        }
        left = 0;
        right = nums.length - 1;

        while (left + 1 < right){
            int mid = left + (right - left) / 2 ;
            if(nums[mid] == target){
                left = mid;
            }else if (nums[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }

        if(nums[left] == target){
            rightIndex = left;
        }else if (nums[right] == target){
            rightIndex = right;
        }


        return  new int[]{leftIndex,rightIndex};
    }
}
