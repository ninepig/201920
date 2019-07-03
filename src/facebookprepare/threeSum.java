package facebookprepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2019/6/30.
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ; i++){
            // Skip duplicated numbers.
            if(i == 0 || (i > 0 && nums[i-1] != nums[i])){
                int low = i + 1, high = nums.length-1 ,target = 0 - nums[i];
                while(low < high){
                    if(nums[low] + nums[high] == target){
                        res.add(Arrays.asList(nums[low],nums[high],nums[i]));
                        while(low < high&&nums[low] == nums[low+1]){
                            low++;
                        }
                        while(low < high&&nums[high] == nums[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    }else if(nums[low] + nums[high] > target){
                        high--;
                    }else{
                        low++;
                    }
                }
            }
        }
        return res;
    }
}
