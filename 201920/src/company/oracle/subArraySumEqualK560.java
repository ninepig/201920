package company.oracle;

import java.util.HashMap;

/*
非常经典的做法
利用hashmap 以及 2 sum 的思想结合
 */
public class subArraySumEqualK560 {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0,1);
        int sum = 0;
        int res = 0;
        for (int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            if (count.containsKey(sum - k)){
                res += count.get(sum - k);
            }
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }

        return  res;
    }
}
