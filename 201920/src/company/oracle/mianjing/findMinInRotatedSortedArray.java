package company.oracle.mianjing;

/*
上午面了OCI 的电面，面试官应该是印度人，提前了十分钟发来了codepad 的邮件，然后电话也就来了。
没多余介绍，直接进入主题coding。
题目很简单，刷题网 以无私 的变形。return 是 shift 了几位， 其实就是找到了index 就好了。上来给我的例子里面就有重复元素，说实话有点蒙，没想到这么直白的。
正式开始coding 之前，array是左右rotate，sort 是 asending desending 都讨论了，虽然最后写只写了一种最基本情况。

剩下的时间就是写unit test，我大概提出了五个test case，他挑了三种让我写，run 过了。
这个面试官有点喜欢看到什么错误就立刻指出来，写test的时候我copy了一个 parameter 的name（类似于testArray1，testArray2 这种），还没等把数字改了他开始提醒我，你要改数字。

因为开始早了，而且留下了大把的时间，剩下就变成了纯聊天，这个部分我倒是觉得跟面试官聊的很开心。有一种跟同事聊天的感觉。
 */
public class findMinInRotatedSortedArray {
    class noDuplicated {
        // Classic binary search
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int left = 0 , right = nums.length - 1;
            while (left + 1 < right){
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[right]) {
                    right = mid;
                }else {
                    left = mid;
                }
            }
            return Math.min(nums[left], nums[right]);
        }
    }
    class Duplicated{
        // Classic binary search
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int begin = 0 , right = nums.length - 1;
            while (begin +1 < right){
                int mid = begin + (right - begin)/2;
                if (nums[mid] == nums[right]){
                    right -- ;
                }else if (nums[mid] < nums[right]){
                    right = mid;
                }else {
                    begin = mid;
                }
            }
            // if this is asending
            if (nums[begin] <= nums[right]){
                return begin;
            }
            return right;
        }
    }
}
