package company.oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class treeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if ( nums == null  || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length - 2 ; i++){
            // Remove duplicated
            if (i == 0 || (i > 0 && nums[i- 1] != nums[i])){
                int l = i + 1 , r = nums.length -1;
                int sum = -nums[i];
                while ( l < r){
                    if (nums[l] + nums[r] == sum){
                        res.add(Arrays.asList(nums[l],nums[r],nums[i]));
                        while (l < r && nums[l] == nums[l+1]){
                            l++;
                        }
                        while (l < r && nums[r] == nums[r-1]){
                            r--;
                        }
                        l++;
                        r--;
                    }else if (nums[l] + nums[r] > sum){
                        r--;
                    }else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
