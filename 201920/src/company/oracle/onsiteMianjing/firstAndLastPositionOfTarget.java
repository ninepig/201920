package company.oracle.onsiteMianjing;

public class firstAndLastPositionOfTarget {

    /*
    当edge case的时候需要问问清楚
     */
    public int[] searchRangeN(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        int first = -1;
        int last = -1;
        // o(N) method
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                first = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                last = i;
                break;
            }
        }

        return new int[]{first, last};
    }

    public int[] searchRangeLogN(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        // Binary search
        int fisrt = 0, last = nums.length - 1;
        int firstShow = -1 , lastShow = -1;
        while (fisrt + 1 < last){
            int mid = fisrt + (last - fisrt) / 2;
            // It will be a tricky , if num[mid] == target , it should be last == mid , let that number to be the right part.
            if (nums[mid] >= target){
                last = mid;
            }else {
                fisrt = mid;
            }
        }

        if (nums[fisrt] == target){
            firstShow = fisrt;
        }else if (nums[last] == target){
            firstShow = last;
        }

         fisrt = 0 ;
         last = nums.length - 1;
         // It will be a tricky , if num[mid] == target , it should be first == mid , let that number to be the left part.
        while (fisrt + 1 < last){
            int mid = fisrt + (last - fisrt) / 2;
            if (nums[mid] > target){
                last = mid;
            }else {
                fisrt = mid;
            }
        }

        if (nums[last] == target){
            lastShow = last;
        }else if (nums[fisrt] == target){
            lastShow = fisrt;
        }

        return new int[]{firstShow,lastShow};
    }
}