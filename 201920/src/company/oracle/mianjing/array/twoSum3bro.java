package company.oracle.mianjing.array;

import java.util.*;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=556368&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

力抠一
利口依遛期
立扣陆武三


two sum 三兄弟

 */
public class twoSum3bro {
    public int[] twoSum1(int[] array , int sum){
        if (array == null || array.length == 0) return new int[]{};
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0 ; i < array.length ; i++){
            if (map.containsKey(sum - array[i])){
                return new int[] { i, map.get(sum - array[i])};
            }else{
                map.put(array[i] , i);
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[]{};
        int left = 0 , right = numbers.length - 1;
        while (left < right){
            if (numbers[left] + numbers[right] == target){
                return new int[]{left , right};
            }else if (numbers[left] + numbers[right] <target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{};
    }

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
