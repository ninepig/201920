package subcategory.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2019/7/5.
 * 经典老题，想明白再做
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null ||nums.length == 0) return  null;
        List<List<Integer>> res =  new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length - 2 ; i++){
            if (i==0 || (i>0 && nums[i-1] != nums[i])){
                int low = i+1 , high = nums.length - 1 , target  = -nums[i];
                while (low < high){
                    if (nums[low] + nums[high] == - nums[i]){
                        res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while (low < high && nums[low] == nums[low+1]){
                            low++;
                        }
                        while (low < high && nums[high] == nums[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    }else if (nums[low] + nums[high] < -nums[i] ){
                        low++;
                    }else {
                        high--;
                    }
                }
            }
        }
        return res;
    }
}