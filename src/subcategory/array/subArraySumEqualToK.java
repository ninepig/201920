package subcategory.array;

import java.util.HashMap;

/**
 * Created by yangw on 2019/7/3.
 * prefix + sum,count mapping hashmap
 * 关键是理解了hashmap在这边的作用，前缀和的出现次数
 */
public class subArraySumEqualToK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for (int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            if (map.containsKey(k-sum)){
                count += map.get(k - sum);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

}
