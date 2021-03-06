package subcategory.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by yangw on 2019/7/5.
 */
public class intersectionOfTwoArrays {
    // No duplicated in result
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int num:nums1) set.add(num);
        for(int num:nums2){
            if(set.contains(num)){
                set.remove(num);
                arr.add(num);
            }
        }
        int k=0;
        int[] res=new int[arr.size()];
        for(Integer num: arr){
            res[k++]=num;
        }
        return res;
    }
    // What if the given array is already sorted? How would you optimize your algorithm?
// Use two pointers

// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// Use hash on nums1 and scan nums2, less space but more time
// Use hash on nums2 and scan nums1, less time but more space
// Or maybe use binary search on nums2(if sorted)
// What if elements of nums2 are stored on disk, and memory is limited so that you can't load all elements into memory at once?
// Or maybe use binary search on nums1(sorted first)
// Or maybe use hash on nums1(need space)

//	*
//    If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.
//	*
//    If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.



// Binary search如果找到了一个元素index，那就用这次的index作为下次binary search的开始。可以节约掉之前的东西，不用search了。
// 然后问，如果找不到呢，如何优化。说如果找不到，也返回上次search结束的index，然后下次接着search。
// 就是上一次找到了，就用这个index继续找这次的；如果找不到，也有一个ending index，就用那个index当starting index。
// 比如[1, 89，100]，去找90；如果不存在，那么binary search的ending index应该是89，所以下次就从那个index开始。
// 如果找不到，会返回要插入的位置index + 1，index是要插入的位置，我写的就是返回要插入的index的。
// 但是不管返回89还是100的index都无所谓，反正只差一个，对performance没有明显影响的。


    // Sort one array & Binary Search it, O(mlogn) time and O(n) space
    public class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) {
                return new int[]{};
            }
            HashSet<Integer> set = new HashSet<>();//you can use ArrayList here as well
            Arrays.sort(nums1);
            for (int i : nums2) {
                if (!set.contains(i) && binarySearch(nums1, i)) {
                    set.add(i);
                }
            }
            int[] res = new int[set.size()];
            int i = 0;
            for (int num : set) {
                res[i++] = num;//remember to i++ !!!
            }
            return res;
        }

        private boolean binarySearch(int[] a, int target) {
            if (a == null || a.length == 0) {//remember to check whether a is null or empty !!!
                return false;
            }
            int start = 0;
            int end = a.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (a[mid] == target) {
                    return true;
                } else if (a[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (a[start] == target || a[end] == target) {
                return true;
            }
            return false;
        }
    }
}
