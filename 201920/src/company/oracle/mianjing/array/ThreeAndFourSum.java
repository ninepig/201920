package company.oracle.mianjing.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2019/12/16.
 * 1. find unique triplets, 4plets, nplets( nplets就 triplets做recursion的base case就行）
 */
public class ThreeAndFourSum {

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
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-3 ; i++){
            if(i == 0 || (i> 0 &&nums[i] != nums[i-1])){
                for(int j = i+1; j< nums.length-2 ; j++){
                    if(j == i+1 || (j > i+1 && nums[j] != nums[j-1])){
                        int left = j + 1 , right = nums.length - 1 ;
                        while(left < right){
                            int sum = nums[left] + nums[right] + nums[i] + nums[j];
                            if(sum == target){
                                res.add(Arrays.asList(nums[i],nums[j],nums[right],nums[left]));
                                while(left < right && nums[left] == nums[left+1]) left++;
                                while(left < right && nums[right] == nums[right -1]) right--;
                                left++;
                                right--;
                            }else if (sum > target){
                                right --;
                            }else {
                                left++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }


    int len = 0;
    public List<List<Integer>> fourSumTest(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(index >= len) {
            return res;
        }
        if(k == 2) {
            int i = index, j = len - 1;
            while(i < j) {
                //find a pair
                if(target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target-nums[i]);
                    res.add(temp);
                    //skip duplication
                    while(i<j && nums[i]==nums[i+1]) i++;
                    while(i<j && nums[j-1]==nums[j]) j--;
                    i++;
                    j--;
                    //move left bound
                } else if (target - nums[i] > nums[j]) {
                    i++;
                    //move right bound
                } else {
                    j--;
                }
            }
        } else{
            for (int i = index; i < len - k + 1; i++) {
                // Use current number to reduce ksum into k-1sum.
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if(temp != null){
                    //add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }


    public List<List<Integer>> kSum(int target , int[] arr , int k){
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0) return res;
        Arrays.sort(arr);
        helper(target , res, arr, k , 0 );
        return res;
    }

    private List<List<Integer>> helper(int target, List<List<Integer>> res, int[] arr, int k, int index) {
        if (index >= arr.length){
            return res;
        }

        if (k == 2){
            int i = index , j = arr.length - 1;
            while (i < j){
                if (target - arr[i] == arr[j]){
                    res.add(Arrays.asList(arr[i] , arr[j]));
                    while (i < j && arr[i] == arr[i+1]){
                        i++;
                    }
                    while (i < j && arr[j-1] == arr[j]) {
                        j--;
                    }
                    i++;
                    j--;
                }else if(arr[i] + arr[j] < target){
                    i++;
                }else {
                    j--;
                }
            }
        }else{
                for (int i = index ; i < arr.length - k + 1 ; i++){
                    List<List<Integer>> temps = helper(target - arr[i], res, arr, k - 1 , i + 1);
                    for (List<Integer> temp : temps){
                        temp.add(0, arr[i]);
                    }
                    res.addAll(temps);
                while (i < arr.length - 1 && arr[i] == arr[i+1]){
                    i++;
                }
            }
        }
        return  res;
    }

}
