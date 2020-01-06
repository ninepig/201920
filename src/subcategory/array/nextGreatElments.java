package subcategory.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yangw on 2019/7/2.
 */
public class nextGreatElments {
    // 2兄弟 stack
    // HashMAP 维护后面比前面这个大的数，因为是第一个数组mapping到后面这个数组里的
     public int[] nextGreaterElement(int[] findNums, int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
    Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            // 经典代码
        while (!stack.isEmpty() && stack.peek() < num)
            map.put(stack.pop(), num);
        stack.push(num);
    }
        for (int i = 0; i < findNums.length; i++)
    findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
}


// Cycle array
//    way is to use a stack to facilitate the look up. First we put all indexes into the stack, smaller index on the top.
//    Then we start from end of the array look for the first element (index) in the stack which is greater than the current one.
//    That one is guaranteed to be the Next Greater Element. Then put the current element (index) into the stack.
//    Time complexity: O(n).

    public class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];

            Stack<Integer> stack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                stack.push(i);
            }

            for (int i = n - 1; i >= 0; i--) {
                result[i] = -1;
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    result[i] = nums[stack.peek()];
                }
                stack.add(i);
            }
            return result;
        }
    }
}
