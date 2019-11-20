package company.oracle;

public class searchInRotatedArray3381 {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0 , right = nums.length - 1;

        while (left + 1 < right){
            int mid = left + (right - left) /2 ;
            if(nums[mid] == target) return mid;
            if (nums[mid] > nums[left]){
                if (target <= nums[mid] && target >= nums[left]){
                    right = mid;
                }else{
                    left = mid;
                }
            }else{
                if ( target >= nums[mid] && target <= nums[right]){
                    left = mid;
                }{
                    right = mid;
                }
            }
        }
        if ( nums[left] == target) return left;
        else if (nums[right] == target) return right;
        else return -1;
    }


    public boolean search2(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return false;
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start + 1 < end){
            mid = start + (end -start)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[start]){
                if(nums[mid] >= target && nums[start] <= target) end = mid;
                else start = mid;
            }else if (nums[mid] < nums[start]){
                if(nums[mid]<= target && nums[end]>=target) start = mid;
                else end = mid;
            }else{
                // start = mid = end;
                start++;
            }
        }
        if(nums[start] == target || nums[end] == target){
            return true;
        }
        return false;
    }

}
