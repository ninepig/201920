package company.oracle.onsiteMianjing;

public class searchInSortedArrayAndRotatedArray {

    // LogN
    public int searchInSortedArray(int[] arr , int target){
        if (arr == null || arr.length == 0) return  -1;
        int begin = 0 , end = arr.length - 1;
        while (begin + 1 < end){
            int mid = begin + (end - begin) / 2 ;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                end = mid;
            }else {
                begin = mid;
            }
        }
        if (arr[begin] == target){
            return  begin;
        }else if (arr[end] == target){
            return end;
        }
        return -1;
    }

    //logN
    public int searchInRotatedArray(int[] arr , int target){
        if (arr == null || arr.length == 0) return  -1;
        int begin = 0 , end = arr.length - 1;
        while (begin + 1 < end){
            int mid = begin + (end - begin) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < arr[begin]){
                if (arr[mid] >= target && target <= arr[end]){
                    begin = mid;
                }else {
                    end = mid;
                }
            }else {
                if (arr[mid] >= target && target >= arr[begin]){
                    end = mid;
                }else {
                    begin = mid;
                }
            }
        }
        if (arr[begin] == target){
            return begin;
        }else if (arr[end] == target ){
            return end;
        }
        return -1;
    }

    // worst case n
    public boolean search2Duplciated(int[] nums, int target) {
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
