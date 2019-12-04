package company.oracle;

public class firstAndLastPostOfTargetNumber {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) return new int[]{};
        int left = 0 , right = nums.length - 1;
        int firstPos = - 1 , lastPost = -1;

        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid]>= target) {
                right = mid;
            }else {
                left = mid;
            }
        }
        if (nums[left] == target){
            firstPos = left;
        }else if (nums[right] == target){
            firstPos = right;
        }
        left = 0 ;
        right = nums.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid]<= target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if (nums[right] == target){
            lastPost = left;
        }else if (nums[left] == target){
            lastPost = right;
        }
        return new int[]{firstPos , lastPost};
    }
}