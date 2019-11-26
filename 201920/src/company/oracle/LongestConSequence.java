package company.oracle;

import java.util.HashMap;
import java.util.Map;

/*
Longest Consecutive Sequence
因为要用o(N)的方法， 所以不能排序， 只能用到hashmap 来用空间换效率


 */
public class LongestConSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if (!map.containsKey(nums[i])){
                int left = (map.containsKey(nums[i] - 1)) ? map.get(nums[i] - 1) : 0;
                int right = (map.containsKey(nums[i] + 1)) ? map.get(nums[i] + 1) : 0;

                // Update map's value
                map.put(nums[i] , left + right + 1);

                // update biggest one.
                max = Math.max(max , left + right +1);

                //update left and right one.Since they are consecutive neighbour.
                map.put(nums[i] - left, left + right + 1);
                map.put(nums[i] + right, left + right + 1);

            }else {
                continue;
            }
        }

        return max;
    }
}