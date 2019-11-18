package Array.normalList;

import java.util.Arrays;
import java.util.HashSet;

public class containDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length - 1 ; i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicateSet(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < nums.length - 1 ; i++){
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

}
