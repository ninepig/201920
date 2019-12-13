package company.oracle.mianjing.array;

import java.util.Stack;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=562646&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

2.一个sorted数组里找target，并返回 target的frequency。
用二分法找到firstIndex， 再用一次二分法找到 lastIndex，最后输出 lastIndex - firstIndex + 1
3 queue和stack的区别是什么？
4，用stack实现queue？
 */
public class firstAndLastPostOfTargetNumberAndStack {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) return new int[]{};
        int left = 0 , right = nums.length - 1;
        int firstPos = - 1 , lastPost = -1;

        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid]>= target) {
                right = mid;
            }else {
                left = mid;
            }
        }
        if (nums[left] == target){
            firstPos = left;
        }else if (nums[right] == target){
            firstPos = right;
        }
        left = 0 ;
        right = nums.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid]<= target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if (nums[right] == target){
            lastPost = left;
        }else if (nums[left] == target){
            lastPost = right;
        }
        return new int[]{firstPos , lastPost};
    }

    class MyQueue {
        Stack<Integer> s1 , s2;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return  s1.isEmpty() && s2.isEmpty();
        }
    }

}