package subcategory.binarysearch;

/**
 * Created by yangw on 2019/7/6.
 */
public class searchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }

        int left = 0,right = nums.length-1;
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){
                if(target>=nums[left]&&target<=nums[mid]){
                    right = mid;
                }else{
                    left = mid;
                }
            }else{
                if(target>=nums[mid]&&target<=nums[right]){
                    left =mid;
                }else{
                    right = mid;
                }
            }
        }
        if(nums[left] == target){
            return left;
        }
        if(nums[right]==target){
            return right;
        }
        return -1;
    }

    public boolean search2(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return false;
        int l = 0;
        int r = nums.length-1;
        while(l<=r) {
            int m = (l+r)/2;
            if(nums[m]==target)
                return true;
            if(nums[m]>nums[l]) {
                if(nums[m]>target && nums[l]<=target) {
                    r = m-1;
                }
                else {
                    l = m+1;
                }
            }
            else if(nums[m]<nums[l]) {
                if(nums[m]<target && nums[r]>=target){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
            else{
                l++;
            }
        }
        return false;
    }
}
