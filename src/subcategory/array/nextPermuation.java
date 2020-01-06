package subcategory.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangw on 2019/7/5.
 */
public class nextPermuation {
    public void nextPermutation(int[] nums){
        if(nums == null || nums.length == 0) return;

        // 314254
        // Find first decreseasing number from end
        // 2
        int i = nums.length - 2;
        while(i>= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        // find first number bigger than 2 from end
        if(i >= 0 ){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            // swap 2 and 4
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums,i+1);
    }

    private void reverse(int[] nums, int i) {
        int l = i, r = nums.length - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    /*
    从后往前寻找索引满足 a[k] > a[k + 1], 如果此条件不满足，则说明已遍历到最后一个。
    从后往前遍历，找到第一个比a[k]小的数a[l], 即a[k] > a[l].
    交换a[k]与a[l].
    反转k + 1 ~ n之间的元素。
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return nums;
        }
        // step1: find nums[i] > nums[i + 1]
        int i = 0;
        for (i = nums.size() - 2; i >= 0; i--) {
            if (nums.get(i) > nums.get(i + 1)) {
                break;
            } else if (i == 0) {
                // reverse nums if reach minimum
                reverse(nums, 0, nums.size() - 1);
                return nums;
            }
        }
        // step2: find nums[i] > nums[j]
        int j = 0;
        for (j = nums.size() - 1; j > i; j--) {
            if (nums.get(i) > nums.get(j)) {
                break;
            }
        }
        // step3: swap betwenn nums[i] and nums[j]
        Collections.swap(nums, i, j);
        // step4: reverse between [i + 1, n - 1]
        reverse(nums, i + 1, nums.size() - 1);

        return nums;
    }

    private void reverse(List<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            Collections.swap(nums, i, j);
        }
    }
}
