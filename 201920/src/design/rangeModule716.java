package design;

import java.util.TreeMap;

/*
体会到了 treemap 的做法
就是个排序的 hashmap！ 红黑树实现
红黑树的特性就是 任何bst的操作都可以在lgn之内完成

这道题就是个画图题。 其实不难。 但是利用了treemap 就很简单。
 */
public class rangeModule716 {
    TreeMap<Integer , Integer> intervals = new TreeMap<>();

    /*
    对于add 就是现在最大的range
    比如现在有 34 567 我们要加上 4--8. 所以我们要把最小的3找出来， 以及8 找出来。
    把一个 range最大化。
     */
    public void addRange(int left, int right){
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if (start != null && intervals.get(start) >= left){
            left = start;
        }
        if (end != null && intervals.get(end) >= right){
            right = intervals.get(end);
        }
        intervals.put(left , right);
        intervals.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left , int right){
        Integer start = intervals.floorKey(left);
        if (start == null ) return false;
        return intervals.get(start) >= right;
    }

    public void removeRange(int left , int right){
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        // put the missing range into map . for example
        /*
        we have 4---5------7---10 , we want delete 5--7.
        adding 7-10, adding 4-5.
         */
        if (end != null && intervals.get(end) > right){
            intervals.put(right , intervals.get(end));
        }
        if (start != null && intervals.get(start) > left){
            intervals.put(start , left);
        }
        intervals.subMap(left,true,right,false).clear();
    }
}
