package company.oracle.mianjing.array;

import java.util.*;
/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=554715&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

面试前看了地里的面经，把题目都过了一遍，但万万没想到，这次电面面试官没有按照以往我印象经验出牌。正文时间如下：
算法只有一道题：一个数组中保留相对顺序删除重复的数。相信大家闭着眼睛都知道该怎么做。那么问题来了，剩下的时候他都问了我些啥？？？
全都是关于Java底层相关的知识点。

1. 先说做题思路，
思路一：用HashSet去重，由此开始问HashSet，HashMap的底层实现，怎样实现O(1), Java Map怎么实现扩容。
Hashset used hashmap to implement .
Hashmap<Hashset object , Object>
Hashmap using keyValue Entry List
O(1) When Entry come, using hashcode to get hashvalue, then use this hashvalue to located index of array.
like a search in the array. so it is o1
MAP Has a factor call load factor . when our array's load exccedd this number , we will double the list.

思路二：先把数组排序再双指针去重。问：有什么好的排序算法，quick/merge，问：快排的最差复杂度是什么，O(n^2)，问怎么才能尽量让快排nlog(n)，尽量是pivot random选取。

1Array already sorted reverse
2 all the elments are same
3 random pick up pivot

继续问：计算时间复杂度BigO的方法是什么，这个我真忘了，想了一下才强行想到是Amortized Time，继续问，什么是AmortizedTime。
go through line of code
caclulate the excution times of each block
a loop will  be o(n) .. a single line will be o(1)
so it will be o (n) + o(1) we get the most time using case as it's time complexity
Amoritieed , some operatio nwill take longer / some will take less.
Amortized time
An amortized time analysis gives a much better understanding of the algorithm.

Consider a sequence of n append operations, where we start with an array of length 1. A careful analysis shows that the total time of these operations is only Θ(n).

There will be a total of n constant-time assignment and increment operations.
The resizing will happen only at operation 1, 2, 4, …, 2k, for a total of 1 + 2 + 4 + …+ 2k = 2·2k - 1 constant-time element copy operations. Since 2k ≤ n, this is at most 2n - 1.
Hence, the amortized time complexity for a single append operation is Θ(1

 上面都问完之后开始写代码。我在最后得到结果的时候用了链表，开始问我：链表结构怎么实现？有什么不好的地方，答：值和指针，内存不连续，问：链表如果有几百万个node，会对jvm造成什么影响？
这个问题我真有点不懂，只能答读取时间会不好，然后我顺嘴说了垃圾回收会有影响。。。（又给自己挖坑），问：那jvm的gc有什么实现机制？ 答：这个我真不知道，只能把之前接触到的 .net的机制讲了一下。
1 It will occupy whole jvm heap area
It will call ooo
2 1 reference conter
  2 GC REACHABLE OBJECT

代码写完之后，写unit test，写了三个test，因为从来没有接触过junit，所有assert语句不是很熟悉，面试官也帮我改了改。anyway 这个就不多说了。
最后还问了 java 的 异常处理机制，两种exception的区别，check 和 uncheck。

1) Checked Exception
The classes which directly inherit Throwable class except RuntimeException and Error are known as checked exceptions e.g. IOException, SQLException etc. Checked exceptions are checked at compile-time.

2) Unchecked Exception
The classes which inherit RuntimeException are known as unchecked exceptions e.g. ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException etc. Unchecked exceptions are not checked at compile-time, but they are checked at runtime.

assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");

https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=560953&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
猎头联系的所以就面了一下
两个人 一个人shadow似乎
很简单的一道题 给定一个array除去所有的重复
由这个题目考到了很多java基础 延展了很多
问得我连蒙带猜得回答 但好在最后也答出来了
随缘了
 */
public class intercectionOfTwoArrays349350TODO {
    public int[] intersectionWithoutDup(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[]{};
        }
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> set =  new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        for(int num : nums2){
            if(set.contains(num)){
                res.add(num);
                set.remove(num);
            }
        }
        int[] resArray =  new int[res.size()];
        for(int i = 0 ; i < res.size(); i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }


    public int[] intersectionTwoPointer(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    // If we want use binary search on this. It could has problem,  you need record previous index.
    public int[] intersectDuplciated(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            r[i] = result.get(i);
        }

        return r;
    }
    public int[] intersectDuplciatedSortedAndTwoPointer(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pnt1 = 0;
        int pnt2 = 0;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        while ((pnt1 < nums1.length) && (pnt2 < nums2.length)) {
            if (nums1[pnt1] < nums2[pnt2]) {
                pnt1++;
            } else {
                if (nums1[pnt1] > nums2[pnt2]) {
                    pnt2++;
                } else {
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }
        int[] res = new int[myList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = (Integer) myList.get(i);
        }
        return res;
    }
}
